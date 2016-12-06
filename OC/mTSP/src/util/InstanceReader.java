package util;

import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstanceReader {
	
	
	public static int[][] read(String filename){
		
		int[][] matRes = null;
		
		try{
			Scanner sc = new Scanner(new FileReader(filename));
			
			String res;
			
			res = sc.nextLine();
			
			Pattern dim = Pattern.compile("DIMENSION : (\\d+)");
			Matcher m = dim.matcher(res);
			
			while(!m.matches() && sc.hasNextLine()){
				res = sc.nextLine();
				m = dim.matcher(res);
			}
			
			int size = Integer.parseInt(m.group(1));
			
			matRes = new int[size][size];
			
			while(!sc.hasNextInt()){
				sc.next();
			}
			
			
			sc.nextInt();
			int i = 0;
			int j = 0;
			matRes[0][0] = 0;
			
			while(sc.hasNextInt()){
				int temp = sc.nextInt();
				j++;
				if (j>= size){
					i++;
					j=i;
				}
				matRes[i][j] = temp;
				matRes[j][i] = temp;
			}
			
			
			sc.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return matRes;
	}

	
	public static void main(String[] args){
		int[][] test = InstanceReader.read("randomA100.tsp");
		for(int i = 0; i<test.length; i++){
			for(int j = 0; j<test.length; j++){
				System.out.print(test[i][j] + " ");
			}
			System.out.println("");
		}

	}
}
