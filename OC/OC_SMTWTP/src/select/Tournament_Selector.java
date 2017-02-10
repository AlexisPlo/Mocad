package select;

import java.util.ArrayList;
import java.util.Random;

import evaluation.SMTWTP_Eval;

import solution.SMTWTP_Pop;
import solution.SMTWTP_Sol;

public class Tournament_Selector implements SMTWTP_Select{
	
	private int k;
	private Random rng;
	
	public Tournament_Selector(int k, Random rng){
		this.k = k;
		this.rng = rng;
	}

	@Override
	public SMTWTP_Sol select(SMTWTP_Pop pop, SMTWTP_Eval evaluator) {
		ArrayList<SMTWTP_Sol> potentialList = new ArrayList<SMTWTP_Sol>();
		int pop_size = pop.size();
		ArrayList<Integer> possibleList = new ArrayList<Integer>();
		for(int i = 0; i < pop.size(); i++){
			possibleList.add(i);
		}
		
		
		
		for (int i = 0; i < k; i++){
			int randint = rng.nextInt(pop_size-i);
			potentialList.add(pop.get(possibleList.get(randint)));
			possibleList.remove(randint);
		}
		
		int best_fitness = Integer.MAX_VALUE;
		SMTWTP_Sol best_sol = null;
		for (int i = 0; i < k; i++){
			int fit = Integer.MAX_VALUE;
			try {
				fit = evaluator.evaluate(potentialList.get(i));
			}
			catch(Exception e){
				System.out.println("EVAL FAILED");
			}
			if (fit < best_fitness){
				best_sol = potentialList.get(i);
			}
			
		}
		
		return best_sol;
		
	}

	
	
	
	
}
