package algo;

import java.util.List;

import problem.MTSP;
import solution.MTSP_Sol;

public class ScalarMOILS extends MTSP_Algo{

	public ScalarMOILS(MTSP inst) {
		super(inst);
	}

	@Override
	public List<MTSP_Sol> run() {
		
		MTSP_Sol actual = MTSP_Sol.random_sol(this.inst.getInstance_size());

		
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
