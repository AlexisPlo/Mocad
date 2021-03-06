package selection;

import neighboor.Neighbourhood;
import solution.SMTWTP_Sol;
import evaluation.SMTWTP_Eval;

public class First_Improv extends Selector{

	@Override
	public SMTWTP_Sol selectSol(SMTWTP_Sol initial, Neighbourhood nei, SMTWTP_Eval eval) throws IllegalStateException {
		this.evaluation_counter = 0;
		SMTWTP_Sol actual = initial;
		int old_score = eval.evaluate(actual);
		int best_score = old_score;
		
		nei.init(actual);
		while(nei.hasNext()){
			SMTWTP_Sol challenger = nei.next();
			int new_score = eval.evaluate(challenger);
			this.evaluation_counter++;
			if (new_score < best_score){
				return challenger;
			}
		}

		return actual;
	}

}
