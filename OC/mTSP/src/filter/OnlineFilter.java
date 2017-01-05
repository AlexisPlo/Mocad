package filter;

import java.util.ArrayList;

import problem.MTSP;
import evaluation.MTSP_Evaluator;

import solution.MTSP_Sol;
import util.InstanceReader;
import util.SolListPrinter;

public class OnlineFilter extends ArrayList<MTSP_Sol>{

	public OnlineFilter(){
		super();
	}
	
	public void addToFilter(MTSP_Sol newSol){
		boolean dominated = false;
		ArrayList<MTSP_Sol> solToRemove = new ArrayList<MTSP_Sol>();
		for (MTSP_Sol s: this){
			if (s.dominates(newSol)){
				dominated = true;
				break;
			}
			if (newSol.dominates(s)){
				solToRemove.add(s);
			}
		}
		if (!dominated) {
			for(MTSP_Sol s: solToRemove){
				this.remove(s);
			}
			this.add(newSol);
		}
	}
	
	
	public static void main (String[] args){
		
		int[][] mat1 = InstanceReader.read("randomA100.tsp");
		int[][] mat2 = InstanceReader.read("randomB100.tsp");
		MTSP theInstance = new MTSP(mat1.length, mat1, mat2);
		
		MTSP_Evaluator evaluator = new MTSP_Evaluator(theInstance);
		
		OnlineFilter filter = new OnlineFilter();
	
		for(int i = 0; i<10000; i++){
			MTSP_Sol newSol = MTSP_Sol.random_sol(100);
			newSol.evaluateSol(evaluator);
			filter.addToFilter(newSol);
		}
		
		
		System.out.println();
		
		SolListPrinter.printTo(filter, "randomOnline.tsp");
		
		
	}
}
