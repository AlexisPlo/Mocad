package selection;

import evaluation.SMTWTP_Eval;
import solution.SMTWTP_Sol;
import neighboor.Neighbourhood;

public abstract class Selector {
	
	protected int evaluation_counter;

	public Selector(){
		this.setEvaluation_counter(0);
	}
	
	public abstract SMTWTP_Sol selectSol(SMTWTP_Sol initial, Neighbourhood nei, SMTWTP_Eval eval) throws IllegalStateException;

	public int getEvaluation_counter() {
		return evaluation_counter;
	}

	public void setEvaluation_counter(int evaluation_counter) {
		this.evaluation_counter = evaluation_counter;
	}
}
