package selection;

import evaluation.SMTWTP_Eval;
import solution.SMTWTP_Sol;
import neighboor.Neighbourhood;

public interface Selector {

	
	public SMTWTP_Sol selectSol(SMTWTP_Sol initial, Neighbourhood nei, SMTWTP_Eval eval) throws Exception;
}
