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
	private int runNb;
	private double[] execTime;
	
	
	public AlgoEval(SMTWTP_Algo algo, List<SMTWTP> instances, int runNb){
		this.algo = algo;
		this.instances = instances;
		best = new int[100];
		myRes = new int[100];
		wDiff = new double[100];
		execTime = new double[100];
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
		this.runNb = runNb;
		
	}
	
	
	public void runAlgos(){
		for (int k = 0; k<runNb; k++){
			for (int i = 0; i<100; i++){
				long startTime = System.nanoTime();
				algo.setInstance(instances.get(i));
				SMTWTP_Sol mySol = algo.run();
				
				long endTime = System.nanoTime();

				long duration = (endTime - startTime)/ (long) 1000000.0;
				execTime[i] += duration;
				myRes[i] = algo.evalSol(mySol);
				double elem_sum = myRes[i] - best[i];
				if (best[i] != 0){
					elem_sum = elem_sum / best[i];
				}
				wDiff[i] += elem_sum;
			}
			System.out.println(Integer.toString(k));
		}
		for (int i = 0; i<100; i++){
			wDiff[i] = wDiff[i] / runNb;
			execTime[i] = execTime[i] / runNb;
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
	
	public double averageDuration(){
		double temp_sum = 0;
		for (int i = 0; i<100; i++){
			temp_sum += execTime[i];
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
		AlgoEval ae = new AlgoEval(null, null, 1);
		for (int i = 0; i<100; i++){
			System.out.println(ae.best[i]);
		}
	}
	
	
}
