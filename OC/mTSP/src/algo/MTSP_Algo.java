package algo;

import java.util.List;

import evaluation.MTSP_Evaluator;

import problem.MTSP;

import solution.MTSP_Sol;


public abstract class MTSP_Algo {

	protected MTSP inst;
	protected MTSP_Evaluator evaluator;
	
	public MTSP_Algo(MTSP inst){
		this.inst = inst;
		this.evaluator = new MTSP_Evaluator(inst);
	}
	
	public abstract List<MTSP_Sol> run();
}