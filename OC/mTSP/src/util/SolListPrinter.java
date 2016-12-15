package util;

import java.io.PrintWriter;
import java.util.List;

import solution.MTSP_Sol;

public class SolListPrinter {
	
	
	
	public static void printTo(List<MTSP_Sol> solList, String filename){
		
		try{
			PrintWriter writer = new PrintWriter(filename);
			for (MTSP_Sol s:solList){
				String line = Integer.toString(s.getEval().getObj1());
				line += "\t" + Integer.toString(s.getEval().getObj2());
				writer.println(line);
			}
			writer.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
