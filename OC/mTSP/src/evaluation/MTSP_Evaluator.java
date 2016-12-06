package evaluation;

import problem.MTSP;
import solution.MTSP_Sol;

public class MTSP_Evaluator {

	
	private MTSP instance;
	
	public MTSP_Evaluator(MTSP instance){
		this.instance = instance;
	}
	
	public MTSP_Eval evaluate(MTSP_Sol sol){
		
		int valObj1 = 0;
		int valObj2 = 0;
		
		for(int i = 0; i<instance.getInstance_size() - 1; i++){
			valObj1 += instance.getMat_obj1()[sol.get(i)][sol.get(i+1)];
			valObj2 += instance.getMat_obj2()[sol.get(i)][sol.get(i+1)];
		}
		
		return new MTSP_Eval(valObj1, valObj2);
	}
	
	
	
	public static void main(String[] args){
		
		
		
	}
	
	
}
