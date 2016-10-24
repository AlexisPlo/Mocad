package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ReadParser {

	
	
	private String filename;

	public ReadParser(String filename) {
		super();
		this.filename = filename;
	}
	
	
	public List<Read> parseFile(){
		
		List<Read> res = new ArrayList<Read>();
		
		try{
		
			BufferedReader br = new BufferedReader(new FileReader(this.filename));
			
			String line = br.readLine();
			
			while(line != null){
				if(Pattern.matches("@.*length", line)){
					String readSeq = br.readLine();
					res.add(new Read(readSeq));
				}
			}
		
		
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
		
		
	}
	
	
	public static void main(String[] args){
		ReadParser rp = new ReadParser("SRR1930021.fastq");
		List<Read>
	}
	
}
