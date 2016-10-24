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
			System.out.println("g: " + g);
			System.out.println("d: " + d);
			int m = (d - g) / 2 + g;
			
			int suffixPos = intArray[m];
			
			int comp = comparePos(r, suffixPos);
			
			if(comp == 1){
				g = m+1;
			}
			else if(comp == -1){
				d = m-1;
			}
			else{
				
				System.out.println(suffixPos);
				
				r.addSeededpos(suffixPos);
				
				int firstFind = m;
				
				boolean differs = false;
				
				
				while(!differs && m > 0){
					m--;
					suffixPos = intArray[m];
					comp = comparePos(r, suffixPos);
					if (comp == 0){
						System.out.println(suffixPos);
						r.addSeededpos(suffixPos);
					}
					else{
						differs = true;
					}
					
				}
				
				m = firstFind;
				differs = false;
				
				while(!differs && m < intArray.length){
					m++;
					suffixPos = intArray[m];
					comp = comparePos(r, suffixPos);
					if (comp == 0){
						System.out.println(suffixPos);
						r.addSeededpos(suffixPos);
					}
					else{
						differs = true;
					}
					
				}
				break;
			}
			
			/*int i = 0;
			while( i<r.getContent().length()){
				if(suffixPos + i >= sa.getBaseText().length()){
					g = m + 1;
					break;
				}
				char cr = r.getContent().charAt(i);
				char ct = sa.getBaseText().charAt(suffixPos + i);
				if (cr < ct){
					d = m - 1;
					System.out.println("smaller");
					break;
				}
				else if (cr > ct){
					g = m + 1;
					System.out.println("greater");
					break;
				}
				i++;
			}*/

		}
		
	}
	
	public int comparePos(Read r, int posT){
		
		int i = 0;
		while( i<r.getContent().length()){
			if(posT + i >= sa.getBaseText().length()){
				return 1;
			}
			char cr = r.getContent().charAt(i);
			char ct = sa.getBaseText().charAt(posT + i);
			if (cr < ct){
				System.out.println("smaller");
				return -1;
			}
			else if (cr > ct){
				System.out.println("greater");
				return 1;
			}
			i++;
		}
		System.out.println("equal");
		return 0;
	}
	
	
	

	public SuffixArray getSa() {
		return sa;
	}

	public void setSa(SuffixArray sa) {
		this.sa = sa;
	}
	
	public static void main(String[] args){
		SuffixArray test = new SuffixArray("actgtcgtagctagctgtagcacgagctg");
		test.buildTable();
		
		ExactSearch es = new ExactSearch(test);
		
		Read re = new Read("tagc");
		es.search(re);
		
		System.out.println(re.getSeededpos());
		
		
	}
	
	
}
