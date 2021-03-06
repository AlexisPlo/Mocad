package algorithm;

import evaluation.SMTWTP_Eval;
import problem.SMTWTP;
import solution.SMTWTP_Sol;

public abstract class SMTWTP_Algo {

	protected SMTWTP inst;
	protected SMTWTP_Eval evaluator;
	
	public SMTWTP_Algo(SMTWTP inst){
		this.inst = inst;
		this.evaluator = new SMTWTP_Eval(inst);
	}
	
	public void setInstance(SMTWTP inst){
		this.inst = inst;
		this.evaluator = new SMTWTP_Eval(inst);
	}
	
	public int evalSol(SMTWTP_Sol sol){
		return this.evaluator.evaluate(sol);
	}
	
	public abstract SMTWTP_Sol run();
}
