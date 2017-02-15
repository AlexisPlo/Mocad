package main;

import java.util.List;
import java.util.Random;

import crossover.Order_Based_Crossover;
import neighboor.SMTWTP_Exchange;
import neighboor.SMTWTP_Insert;
import neighboor.SMTWTP_Swap;
import perturbation.SMTWTP_PerturbInsert;
import popInit.Hybrid_Initiator;
import problem.SMTWTP;
import select.Tournament_Selector;
import selection.Best_Improv;
import selection.First_Improv;
import selection.Selector;
import solution.SMTWTP_Sol;
import algorithm.EDD;
import algorithm.HillClimbing;
import algorithm.ILS;
import algorithm.MDD;
import algorithm.RandomSol;
import algorithm.SMTWTP_Algo;
import algorithm.SimpleGA;
import algorithm.VND;
import mutation.Swap_Mutation;
import evaluation.AlgoEval;
import evaluation.SMTWTP_Eval;

public class MainClass {

	public static void main(String[] args){
		
		
		
		
		List<SMTWTP> instances = SMTWTP.readSMTWTPInstancesFile("wt100.txt", 100);
		
		Random r = new Random(42);
		
		//SMTWTP_Algo algo = new RandomSol(instances.get(0), r);
		SMTWTP_Algo algo = new HillClimbing(instances.get(0), new Best_Improv(), new SMTWTP_Exchange(), 2);
		//SMTWTP_Algo algo = new VND(instances.get(0), new First_Improv(), 1, new MDD(instances.get(0)));
		//SMTWTP_Algo algo = new SimpleGA(instances.get(0), new Hybrid_Initiator(r),
				//new Tournament_Selector(2, r), new Order_Based_Crossover(r), new Swap_Mutation(r), null, 50, 100000);
		
		AlgoEval ae = new AlgoEval(algo, instances,5);
		
		ae.runAlgos();
		
		System.out.println("La moyenne de la déviation avec les meilleurs résultats est de: " + ae.meanWeightedDiff());
		System.out.format("Temps moyen d'éxécution d'un run (en millisecondes): %.4f\n", ae.averageDuration());
	}

}