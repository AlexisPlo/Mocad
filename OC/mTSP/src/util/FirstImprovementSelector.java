package util;

import evaluation.MTSP_Eval;
import evaluation.MTSP_Evaluator;
import evaluation.MTSP_ScalarFitness;
import neighbour.MTSP_Neighbourhood;
import solution.MTSP_Sol;


public class FirstImprovementSelector {
	
	private int evalCounter;


	public MTSP_Sol selectSol(MTSP_Sol initial, MTSP_Neighbourhood nei, MTSP_Evaluator evaluator, MTSP_ScalarFitness sFitness) throws Exception {
		MTSP_Sol actual = initial;
		double old_score = sFitness.assignFitness(actual);		
		nei.init(actual);
		while(nei.hasNext()){
			MTSP_Sol challenger = nei.next();
			challenger.evaluateSol(evaluator);
			double new_score = sFitness.assignFitness(challenger);
			if (new_score < old_score){
				return challenger;
			}
		}

		return actual;
	}

	public int getEvalCounter(){
		return evalCounter;
	}

}
