package filter;

import java.util.ArrayList;
import java.util.List;

import evaluation.MTSP_Evaluator;

import problem.MTSP;

import solution.MTSP_Sol;
import util.InstanceReader;
import util.SolListPrinter;

public class OfflineFilter {
	
	public static ArrayList<MTSP_Sol> filter(List<MTSP_Sol> solList){
		
		ArrayList<MTSP_Sol> resList = new ArrayList<MTSP_Sol>();
		
		for (MTSP_Sol s1:solList){
			boolean dominated = false;
			for(MTSP_Sol s2: solList){
				if(s2 == s1)
					continue;
				if (s2.dominates(s1)){
					dominated = true;
					break;
				}
			}
			if (!dominated){
				resList.add(s1);
			}
		}
		
		return resList;
	}
	
	
	
	public static void main (String[] args){
		
		int[][] mat1 = InstanceReader.read("randomA100.tsp");
		int[][] mat2 = InstanceReader.read("randomB100.tsp");
		MTSP theInstance = new MTSP(mat1.length, mat1, mat2);
		
		MTSP_Evaluator evaluator = new MTSP_Evaluator(theInstance);
		
		ArrayList<MTSP_Sol> solList = new ArrayList<MTSP_Sol>();
	
		for(int i = 0; i<10000; i++){
			MTSP_Sol newSol = MTSP_Sol.random_sol(100);
			newSol.evaluateSol(evaluator);
			solList.add(newSol);
		}
		
		solList = OfflineFilter.filter(solList);
		
		System.out.println();
		
		SolListPrinter.printTo(solList, "randomOffline.tsp");
		
		
	}

}
