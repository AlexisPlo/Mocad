package algo;

import java.util.ArrayList;
import java.util.List;

import algorithm.HillClimbing;

import evaluation.MTSP_ScalarFitness;

import neighbour.MTSP_Neighbourhood;

import problem.MTSP;
import solution.MTSP_Sol;
import solution.SMTWTP_Sol;
import util.FirstImprovementSelector;
import util.SwapPerturbation;

public class ScalarMOILS extends MTSP_Algo{
	
	private MTSP_Neighbourhood nei;
	private SwapPerturbation per;

	public ScalarMOILS(MTSP inst, MTSP_Neighbourhood nei) {
		super(inst);
		this.nei = nei;
		
	}

	@Override
	public List<MTSP_Sol> run() {
		
		List<MTSP_Sol> archive = new ArrayList<MTSP_Sol>();
		
		for(int i = 0; i<11; i++) {
			
			MTSP_Sol actual = MTSP_Sol.random_sol(this.inst.getInstance_size());
			actual.evaluateSol(this.evaluator);
			FirstImprovementSelector select = new FirstImprovementSelector();
			
			int best_score = evaluator.evaluate(actual);
			int evalCounter = 0;
			
			while(evalCounter <= maxEval) {
				MTSP_Sol perturbed = per.applyPerturbation(actual);
				
				
				while(true){
					MTSP_Sol newSol = null;
					try {
						newSol = select.selectSol(perturbed, nei, this.evaluator, new MTSP_ScalarFitness(0, 0));
					}
					catch (IllegalStateException e) {
						System.out.println("EVAL FAILED");
					}
					evalCounter += select.getEvalCounter();
					if (newSol == actual)
						break;
					actual = newSol;
				}
				
				
				
				
				SMTWTP_Sol newSol = hc.run();
				this.evalCounter += hc.getEvalCounter();
				int new_score = evaluator.evaluate(newSol);
				if (new_score < best_score){
					actual = newSol;
					best_score = new_score;
				}
			}
			
			
		}
		
		return null;
	}
	
	
	

}
