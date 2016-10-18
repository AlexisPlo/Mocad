package indexing;

import java.util.Arrays;

import util.Suffix;

public class SuffixArray {

	
	private int[] theArray;
	private String baseText;
	
	public SuffixArray(String text){
		this.baseText = text + "$";
		this.theArray = new int[this.baseText.length()];
	}
	
	public void buildTable(){
		int maxLength = this.baseText.length();
		Suffix[] suffTable = new Suffix[maxLength];
		
		for(int i = 0; i < maxLength; i++){
			Suffix suff = new Suffix(this.baseText.substring(i), i);
			suffTable[i] = suff;
		}
		
		Arrays.sort(suffTable);
		
		for(int i = 0; i < maxLength; i++){
			//System.out.println(suffTable[i].getSuff());
			theArray[i] = suffTable[i].getPos();
		}
		
	}
	
	
	
	
	
	public int[] getTheArray() {
		return theArray;
	}

	public void setTheArray(int[] theArray) {
		this.theArray = theArray;
	}

	public String getBaseText() {
		return baseText;
	}

	public void setBaseText(String baseText) {
		this.baseText = baseText;
	}

	public static void main(String[] args){
		
		SuffixArray test = new SuffixArray("actgtcgtagctagctgtagcacgagctg");
		test.buildTable();
		String res = "";
		for(int i = 0; i < test.getTheArray().length; i++){
			res += Integer.toString(test.getTheArray()[i]) + ",";
		}
		System.out.println(res);
	}
	
}
