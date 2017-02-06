package evaluation;

import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

import problem.SMTWTP;
import solution.SMTWTP_Sol;

import algorithm.SMTWTP_Algo;

public class AlgoEval {

	private int[] best;
	private int[] myRes;
	private double[] wDiff;
	private SMTWTP_Algo algo;
	private static SMTWTP_Eval evaluator;
	private List<SMTWTP> instances;
	private double mean;
	
	
	public AlgoEval(SMTWTP_Algo algo, List<SMTWTP> instances){
		this.algo = algo;
		this.instances = instances;
		best = new int[100];
		myRes = new int[100];
		wDiff = new double[100];
		try{
			Scanner sc = new Scanner(new FileReader("wtbest100b.txt"));
			for (int i = 0; i<100; i++){
				best[i] = sc.nextInt();
			}
			
			sc.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public void runAlgos(){
		for (int i = 0; i<100; i++){
			algo.setInstance(instances.get(i));
			SMTWTP_Sol mySol = algo.run();
			myRes[i] = algo.evalSol(mySol);
			double elem_sum = myRes[i] - best[i];
			if (best[i] != 0){
				elem_sum = elem_sum / best[i];
			}
			wDiff[i] = elem_sum;
		}
	}
	
	public double meanWeightedDiff(){
		double temp_sum = 0;
		for (int i = 0; i<100; i++){
			temp_sum += wDiff[i];
		}
		mean = temp_sum/100;
		return mean;
	}
	
	public double varianceDiff(){
		double temp_sum = 0;
		for (int i = 0; i<100; i++){
			temp_sum += Math.pow(wDiff[i]-mean, 2);
		}
		
		return temp_sum/100;
	}
	
	public static void main (String[] args){
		AlgoEval ae = new AlgoEval(null, null);
		for (int i = 0; i<100; i++){
			System.out.println(ae.best[i]);
		}
	}
	
	
}
