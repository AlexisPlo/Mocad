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
		matrix = new int[text.length()+1][read.length()+1];
		
		for (int i = 0; i < text.length(); i++)
			for (int j = 0; j < read.length(); j++)
				matrix[i][j] = 0;
		
		//Initialisation
		
		for(int i = 0; i<=epsilon && i<text.length(); i++){
			this.matrix[i][0] = 0;
		}
		for(int j = 0; j<=epsilon && j<read.length(); j++){
			this.matrix[0][j] = j * score.getIndel();
		}
		
		//Boucle principale
		
		for(int j = 1; j<=read.length(); j++){
			int imin = Integer.max(1, j - epsilon);
			int imax = Integer.min(text.length(), text.length()- read.length() + epsilon + j );
			
			for(int i = imin; i<= imax; i++){
				
				int best;
				
				if(text.charAt(i-1) == read.charAt(j-1))
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

	
	public void backTrack(String read, String text){
		int maxStart = Integer.MIN_VALUE;
		int bestI = 0;
		
		for(int i = Integer.max(0, read.length() - epsilon); i < text.length(); i++){
			int newStart = matrix[i][read.length()];
			if(newStart > maxStart) {
				bestI = i;
				maxStart = newStart;
			}
		}
		
		int actualI = bestI;
		int actualJ = read.length();
		int actualScore = matrix[actualI][actualJ];
		
		String readString = "";
		String textString = "";
		String alignString = "";
		
		while(actualI != 0 || actualJ != 0){
			int neiScore;
			if (actualI >0 && actualJ >0){
				neiScore = matrix[actualI-1][actualJ-1];
				if (actualScore - neiScore == this.score.getMatch()){
					readString = read.charAt(actualJ-1)+ readString;
					textString = text.charAt(actualI-1)+ textString;
					alignString = "|" + alignString;
					actualI--;
					actualJ--;
					actualScore = neiScore;
					continue;
				}
				if (actualScore - neiScore == this.score.getMismatch()){
					readString = read.charAt(actualJ-1)+ readString;
					textString = text.charAt(actualI-1)+ textString;
					alignString = " " + alignString;
					actualI--;
					actualJ--;
					actualScore = neiScore;
					continue;
				}
			}
			if (actualJ >0){
			neiScore = matrix[actualI][actualJ-1];
				if (actualScore - neiScore == this.score.getIndel()){
					readString = read.charAt(actualJ-1)+ readString;
					textString = "-"+ textString;
					alignString = " " + alignString;
					actualJ--;
					actualScore = neiScore;
					continue;
				}
			}
			if (actualI >0 && actualJ >0){
				neiScore = matrix[actualI-1][actualJ];
				if (actualScore - neiScore == this.score.getIndel()){
					readString = "-"+ readString;
					textString = text.charAt(actualI-1)+ textString;
					alignString = " " + alignString;
					actualI--;
					actualScore = neiScore;
					continue;
				}
			}
			if (actualI >0 && actualJ == 0){
				readString = "-"+ readString;
				textString = text.charAt(actualI-1)+ textString;
				alignString = " " + alignString;
				actualI--;
				continue;
			}
			readString = "@"+ readString;
			textString = "@"+ textString;
			alignString = "@" + alignString;
		}
		
		System.out.println(textString);
		System.out.println(alignString);
		System.out.println(readString);
		
	}
	
	public static void main(String[] args){
		ScoreGrid sc = new ScoreGrid(1,-1,-2);
		KBandAlign al = new KBandAlign(2, sc);
		String read = "agatcgagctagct";
		String text = "gagtcacatcagatcgagctagcgatcgatg";
		
		al.buildMatrix(read, text);
		al.printMatrix();
		al.backTrack(read, text);
	}
	
	
	
}
