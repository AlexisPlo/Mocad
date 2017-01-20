package algorithm;

import neighboor.Neighbourhood;
import perturbation.Perturbation;
import perturbation.SMTWTP_PerturbInsert;
import problem.SMTWTP;
import selection.Selector;
import solution.SMTWTP_Sol;

public class ILS extends SMTWTP_Algo{

	private Selector select;
	private Neighbourhood nei;
	private SMTWTP_Algo init;
	private Perturbation per;
	private int evalCounter;
	private int maxEval;

	public ILS(SMTWTP inst, Selector select, Neighbourhood neighboor, Perturbation per, SMTWTP_Algo init, int maxEval){
		super(inst);
		this.select = select;
		this.nei = neighboor;
		this.init = init;
		this.maxEval = maxEval;
		this.per = per;
	}
	
	public int getEvalCounter(){
		return this.evalCounter;
	}

	@Override
	public SMTWTP_Sol run() {
		
		SMTWTP_Sol actual = this.init.run();
		try{
			int best_score = evaluator.evaluate(actual);
			evalCounter = 0;
			
			while(evalCounter <= maxEval) {
				SMTWTP_Sol perturbed = per.applyPerturbation(actual);
				HillClimbing hc = new HillClimbing(this.inst, this.select, this.nei, perturbed);
				SMTWTP_Sol newSol = hc.run();
				this.evalCounter += hc.getEvalCounter();
				int new_score = evaluator.evaluate(newSol);
				if (new_score < best_score){
					actual = newSol;
					best_score = new_score;
				}
			}
		}
		catch(IllegalStateException e){
			System.out.println("EVAL FAILED");
		}
		return actual;
	}
	
}
