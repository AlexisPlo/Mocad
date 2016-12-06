package problem;

import evaluation.MTSP_Eval;
import evaluation.MTSP_Evaluator;
import solution.MTSP_Sol;
import util.InstanceReader;

public class MTSP {
	
	private int instance_size;
	private int[][] mat_obj1;
	private int[][] mat_obj2;
	
	
	public MTSP(int instance_size, int[][] mat_obj1, int[][] mat_obj2) {
		super();
		this.instance_size = instance_size;
		this.mat_obj1 = mat_obj1;
		this.mat_obj2 = mat_obj2;
	}


	public int getInstance_size() {
		return instance_size;
	}


	public void setInstance_size(int instance_size) {
		this.instance_size = instance_size;
	}


	public int[][] getMat_obj1() {
		return mat_obj1;
	}


	public void setMat_obj1(int[][] mat_obj1) {
		this.mat_obj1 = mat_obj1;
	}


	public int[][] getMat_obj2() {
		return mat_obj2;
	}


	public void setMat_obj2(int[][] mat_obj2) {
		this.mat_obj2 = mat_obj2;
	}
	
	
	public static void main(String[] args){
		
		int[][] mat1 = InstanceReader.read("randomA100.tsp");
		int[][] mat2 = InstanceReader.read("randomB100.tsp");
		MTSP theInstance = new MTSP(mat1.length, mat1, mat2);
		
		MTSP_Evaluator evaluator = new MTSP_Evaluator(theInstance);
		
		MTSP_Sol random = MTSP_Sol.random_sol(100);
		MTSP_Eval eval = evaluator.evaluate(random);
		System.out.println(eval.getObj1());
		System.out.println(eval.getObj2());
	}
	

}
