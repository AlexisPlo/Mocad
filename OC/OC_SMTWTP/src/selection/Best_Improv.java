package selection;

import neighboor.Neighbourhood;
import solution.SMTWTP_Sol;
import evaluation.SMTWTP_Eval;

public class Best_Improv implements Selector{

	@Override
	public SMTWTP_Sol selectSol(SMTWTP_Sol initial, Neighbourhood nei, SMTWTP_Eval eval) {
		SMTWTP_Sol actual = initial;
		int old_score = eval.evaluate(actual);
		int best_score = old_score;
		
		nei.init(actual);
		while(nei.hasNext()){
			SMTWTP_Sol challenger = nei.next();
			int new_score = eval.evaluate(challenger);
			if (new_score < best_score){
				actual = challenger;
				best_score = new_score;
			}
		}


		return actual;
		
	}

}
