package algo;

import util.ScoreGrid;

public class KBandAlign {
	
	private int epsilon;
	private int[][] matrix;
	private ScoreGrid score;
	
	
	public KBandAlign(int e, ScoreGrid score){
		this.epsilon = e;
		this.score = score;
	}
	
	public void buildMatrix(String read, String text){
		matrix = new int[text.length()][read.length()];
		
		for (int i = 0; i < text.length(); i++)
			for (int j = 0; j < read.length(); j++)
				matrix[i][j] = 0;
		
		//Initialisation
		
		for(int i = 0; i<=epsilon && i<text.length(); i++){
			this.matrix[i][0] = i * score.getIndel();
		}
		for(int j = 0; j<=epsilon && j<text.length(); j++){
			this.matrix[0][j] = j * score.getIndel();
		}
		
		//Boucle principale
		
		for(int j = 1; j<read.length(); j++){
			int imin = Integer.max(1, j - epsilon);
			int imax = Integer.min(text.length()-1, j + epsilon);
			
			for(int i = imin; i<= imax; i++){
				
				int best;
				
				if(text.charAt(i) == read.charAt(j))
					best = matrix[i-1][j-1] + score.getMatch();
				else
					best = matrix[i-1][j-1] + score.getMismatch();
						
				if (i > j-epsilon){
					int newscore = matrix[i-1][j] + score.getIndel();
					best = Integer.max(best, newscore);
				}
				
				if(i < j+ epsilon){
					int newscore = matrix[i][j-1] + score.getIndel();
					best = Integer.max(best, newscore);
				}
				
				matrix[i][j] = best;
			}
		}
		
	}
	
	public void printMatrix(){
		for(int j = 0; j <matrix[0].length; j++){
			for(int i = 0; i<matrix.length;i++){
				System.out.printf("%+03d ", matrix[i][j]);
			}
			System.out.println("");
		}
	}

	
	public void backTrack(){
		int maxStart;
		
		for(int i = Integer.max(0, read.length()-1 - epsilon); i; i++){
			
		}
	}
	
	public static void main(String[] args){
		ScoreGrid sc = new ScoreGrid(1,-1,-2);
		KBandAlign al = new KBandAlign(2, sc);
		
		al.buildMatrix("actgcatt", "cactgaattgcazdazd");
		al.printMatrix();
	}
	
	
	
}
