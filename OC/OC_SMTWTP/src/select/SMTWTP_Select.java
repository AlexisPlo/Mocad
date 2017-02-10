package select;

import evaluation.SMTWTP_Eval;
import solution.SMTWTP_Pop;
import solution.SMTWTP_Sol;

public interface SMTWTP_Select {
	
	
	public SMTWTP_Sol select(SMTWTP_Pop pop, SMTWTP_Eval evaluator);

}
