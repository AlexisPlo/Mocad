package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import evaluation.MTSP_Eval;

public class MTSP_Sol extends ArrayList<Integer>{
	
	private MTSP_Eval eval;
	
	public MTSP_Sol(ArrayList<Integer> tList){
		super(tList);
	}
	



	public MTSP_Eval getEval() {
		return eval;
	}



	public void setEval(MTSP_Eval eval) {
		this.eval = eval;
	}



	public boolean dominates(MTSP_Sol other){
		if (this.eval == null || other.getEval() == null){
			return false;
		}
		else{
			if(this.eval.getObj1() < other.getEval().getObj1()){
				if(this.eval.getObj2() <= other.getEval().getObj2())
					return true;
				else
					return false;
			}
			else if(this.eval.getObj1() == other.getEval().getObj1()){
				if(this.eval.getObj2() < other.getEval().getObj2())
					return true;
				else
					return false;
			}
			else{
				return false;
			}
			
		}
	}
	
	
	public static MTSP_Sol random_sol(int size){
		ArrayList<Integer> test = new ArrayList<Integer>();
		
		for (int i = 0; i< size; i++){
			test.add(i);
		}
		
		Collections.shuffle(test);
		return new MTSP_Sol(test);
	}

}
