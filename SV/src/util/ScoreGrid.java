package util;

public class ScoreGrid {
	
	
	private int match;
	private int mismatch;
	private int indel;
	
	public ScoreGrid(int match, int mismatch, int indel) {
		super();
		this.match = match;
		this.mismatch = mismatch;
		this.indel = indel;
	}

	public int getMatch() {
		return match;
	}

	public void setMatch(int match) {
		this.match = match;
	}

	public int getMismatch() {
		return mismatch;
	}

	public void setMismatch(int mismatch) {
		this.mismatch = mismatch;
	}

	public int getIndel() {
		return indel;
	}

	public void setIndel(int indel) {
		this.indel = indel;
	}
	
	
	
}
