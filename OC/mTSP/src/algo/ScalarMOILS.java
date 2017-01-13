package algo;

import java.util.List;

import neighbour.MTSP_Neighbourhood;

import problem.MTSP;
import solution.MTSP_Sol;
import util.FirstImprovementSelector;

public class ScalarMOILS extends MTSP_Algo{
	
	private MTSP_Neighbourhood nei;

	public ScalarMOILS(MTSP inst, MTSP_Neighbourhood nei) {
		super(inst);
		this.nei = nei;
		
	}

	@Override
	public List<MTSP_Sol> run() {
		
		MTSP_Sol actual = MTSP_Sol.random_sol(this.inst.getInstance_size());
		actual.evaluateSol(this.evaluator);
		FirstImprovementSelector select = new FirstImprovementSelector();
		
		while(true) {
			MTSP_Sol newSol = null;
			try {
				newSol = select.selectSol(actual, nei, this.evaluator);
			}
			catch (Exception e) {
				System.out.println("EVAL FAILED");
			}
			if (newSol == actual)
				break;
			actual = newSol;
		}
		
		return null;
	}
	
	
	

}
