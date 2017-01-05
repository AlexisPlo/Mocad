package util;

import evaluation.MTSP_Eval;
import evaluation.MTSP_Evaluator;
import neighbour.MTSP_Neighbourhood;
import solution.MTSP_Sol;


public class FirstImprovementSelector {


	public MTSP_Sol selectSol(MTSP_Sol initial, MTSP_Neighbourhood nei, MTSP_Evaluator eval) throws Exception {
		MTSP_Sol actual = initial;
		MTSP_Eval old_score = eval.evaluate(actual);
		
		nei.init(actual);
		while(nei.hasNext()){
			MTSP_Sol challenger = nei.next();
			MTSP_Eval new_score = eval.evaluate(challenger);
			if (new_score. < old_score){
				return challenger;
			}
		}

		return actual;
	}


}
