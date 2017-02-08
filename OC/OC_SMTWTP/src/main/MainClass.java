package main;

import java.util.List;
import java.util.Random;

import neighboor.SMTWTP_Insert;
import neighboor.SMTWTP_Swap;
import perturbation.SMTWTP_PerturbInsert;
import problem.SMTWTP;
import selection.Best_Improv;
import selection.First_Improv;
import solution.SMTWTP_Sol;
import algorithm.EDD;
import algorithm.HillClimbing;
import algorithm.ILS;
import algorithm.MDD;
import algorithm.RandomSol;
import algorithm.SMTWTP_Algo;
import evaluation.AlgoEval;
import evaluation.SMTWTP_Eval;

public class MainClass {

	public static void main(String[] args){
		
		
		
		
		List<SMTWTP> instances = SMTWTP.readSMTWTPInstancesFile("wt100.txt", 100);
		
		Random r = new Random(42);
		
		SMTWTP_Algo algo = new HillClimbing(instances.get(0), new First_Improv(), new SMTWTP_Swap(), new RandomSol(instances.get(0), r));
		
		AlgoEval ae = new AlgoEval(algo, instances,30);
		
		ae.runAlgos();
		
		System.out.println("La moyenne de la déviation avec les meilleurs résultats est de: " + ae.meanWeightedDiff());
		System.out.format("Temps moyen d'éxécution d'un run (en millisecondes): %.4f\n", ae.averageDuration());
	}

}