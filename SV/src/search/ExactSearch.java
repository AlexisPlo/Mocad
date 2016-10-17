package search;

import indexing.SuffixArray;
import util.Read;

public class ExactSearch {

	
	private SuffixArray sa;

	public ExactSearch(SuffixArray sa) {
		super();
		this.sa = sa;
		
	}
	
	public void search(Read r){
		
		int[] intArray = sa.getTheArray();
		
		int g = 0;
		int d = intArray.length - 1;
		
		while(d - g > 0){
			int m = (d - g) / 2;
			
			int suffixPos = intArray[m];
			
			int i = 0;
			while( i<r.getContent().length()){
				if(suffixPos + i >= sa.getBaseText().length()){
					g = m + 1;
					break;
				}
				char cr = r.getContent().charAt(i);
				char ct = sa.getBaseText().charAt(suffixPos + i);
				if (cr < ct){
					d = m - 1;
					break;
				}
				else if (cr > ct){
					g = m + 1;
					break;
				}
				i++;
			}
			if(i == r.getContent().length()){
				
			}
		}
		
	}
	

	public SuffixArray getSa() {
		return sa;
	}

	public void setSa(SuffixArray sa) {
		this.sa = sa;
	}
	
	
	
}
