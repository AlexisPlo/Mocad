package indexing;

import util.RankSample;

public class BWRankSample {

	private int size;
	private int[] F;
	private char[] L;
	
	private RankSample[] R;
	
	public BWRankSample(SuffixArray sa){
		
		this.size = sa.getTheArray().length;
		this.L = new char[this.size];
		this.F = new int[5];
		
	}
	
	
	public void build(){
		
		
		
	}
	
}
