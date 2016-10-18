package util;

import java.util.ArrayList;
import java.util.List;

public class Read {

	private String content;
	private List<Integer> seededpos;
	private List<Integer> actualpos;
	
	
	
	public Read(String content) {
		super();
		this.content = content;
		this.seededpos = new ArrayList<Integer>();
		this.actualpos = new ArrayList<Integer>();
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Integer> getSeededpos() {
		return seededpos;
	}
	public void setSeededpos(List<Integer> seededpos) {
		this.seededpos = seededpos;
	}
	
	public void addSeededpos(Integer i){
		this.seededpos.add(i);
	}
	public List<Integer> getActualpos() {
		return actualpos;
	}
	public void setActualpos(List<Integer> actualpos) {
		this.actualpos = actualpos;
	}
	public void addActualpos(Integer i){
		this.actualpos.add(i);
	}
	
	
}
