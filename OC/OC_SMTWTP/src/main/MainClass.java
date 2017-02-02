package main;

import java.util.List;
import java.util.Random;

import neighboor.SMTWTP_Insert;
import neighboor.SMTWTP_Swap;
import perturbation.SMTWTP_PerturbInsert;
import problem.SMTWTP;
import selection.First_Improv;
import solution.SMTWTP_Sol;
import algorithm.HillClimbing;
import algorithm.ILS;
import algorithm.MDD;
import algorithm.RandomSol;
import evaluation.AlgoEval;
import evaluation.SMTWTP_Eval;

public class MainClass {

	public static void main(String[] args){
		
		
		Random r = new Random(42);
		
		MDD algo = new MDD(null);
		
		AlgoEval ae = new AlgoEval(algo);
		
		ae.runAlgos();
		
		System.out.println(ae.averageWeightedDiff());
	}
	
}
