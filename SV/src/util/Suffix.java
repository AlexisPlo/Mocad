package util;

public class Suffix implements Comparable<Suffix>{

	private String suff;
	private int pos;
	
	
	
	
	public Suffix(String suff, int pos) {
		super();
		this.suff = suff;
		this.pos = pos;
	}




	@Override
	public int compareTo(Suffix o) {
		
		return this.suff.compareTo(o.getSuff());
	}

	
	
	
	public String getSuff() {
		return suff;
	}




	public void setSuff(String suff) {
		this.suff = suff;
	}




	public int getPos() {
		return pos;
	}




	public void setPos(int pos) {
		this.pos = pos;
	}




	public static void main(String[] args){
		System.out.println("A".compareTo("$"));
		return;
	}
	
}
