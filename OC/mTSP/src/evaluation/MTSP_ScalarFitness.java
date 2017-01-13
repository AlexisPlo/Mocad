package evaluation;

import solution.MTSP_Sol;

public class MTSP_ScalarFitness {
	
	private float weight1;
	private float weight2;
	
	
	
	
	public MTSP_ScalarFitness(float weight1, float weight2) {
		super();
		this.weight1 = weight1;
		this.weight2 = weight2;
	}




	public double assignFitness(MTSP_Sol sol){
		MTSP_Eval solEval = sol.getEval();
		double res = solEval.getObj1()*weight1 + solEval.getObj2()*weight2;
		sol.setFitness(res);
		return res;
	}

}
