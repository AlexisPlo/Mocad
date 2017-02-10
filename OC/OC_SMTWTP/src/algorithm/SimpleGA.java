package algorithm;

import java.util.Random;

import mutation.SMTWTP_Mutation;
import crossover.SMTWTP_Crossover;
import popInit.SMTWTP_PopInit;
import problem.SMTWTP;
import replace.SMTWTP_Replace;
import select.SMTWTP_Select;
import solution.SMTWTP_Pop;
import solution.SMTWTP_Sol;

public class SimpleGA extends SMTWTP_Algo{
	
	private SMTWTP_PopInit initiator;
	private SMTWTP_Select selector;
	private SMTWTP_Crossover crosser;
	private SMTWTP_Mutation mutator;
	private SMTWTP_Replace replacer;
	private int max_eval;
	private int pop_size;
	private int generation_counter;
	private int evaluation_counter;
	



	public SimpleGA(SMTWTP inst, SMTWTP_PopInit initiator,
			SMTWTP_Select selector, SMTWTP_Crossover crosser,
			SMTWTP_Mutation mutator, SMTWTP_Replace replacer, int pop_size, int max_eval) {
		super(inst);
		this.initiator = initiator;
		this.selector = selector;
		this.crosser = crosser;
		this.mutator = mutator;
		this.replacer = replacer;
		this.max_eval = max_eval;
		this.pop_size = pop_size;
		this.generation_counter = 0;
		this.evaluation_counter = 0;
	}




	@Override
	public SMTWTP_Sol run() {
		
		this.generation_counter = 0;
		this.evaluation_counter = 0;
		
		Random rng = new Random();
		
		SMTWTP_Pop actual;
		actual = initiator.generateInit(inst, pop_size);
		
		//Evaluating the generated offspring
		
		for(int i = 0; i<this.pop_size; i++) {
			try {
				this.evaluator.evaluate(actual.get(i));
			}
			catch (Exception e) {
				System.out.println(actual.get(i).getTaskNbList());
				System.out.println("EVAL FAILED");
			}
		}
		
		while(evaluation_counter < max_eval){
			
						
			SMTWTP_Pop newPop = new SMTWTP_Pop();
			
			//Generating offspring via crossover
			for(int i = 0; i<this.pop_size / 2; i++){
				
				//Selecting parents
				SMTWTP_Sol p1 = selector.select(actual, this.evaluator);
				SMTWTP_Sol p2 = selector.select(actual, this.evaluator);
				
				//Crossover
				while (p2 == p1){
					p2 = selector.select(actual, this.evaluator);
				}
				
				crosser.generateOffsprings(p1, p2);
				newPop.add(crosser.getOff1());
				newPop.add(crosser.getOff2());
				
			}
			
			//Mutating offspring according to a probability
			for(int i = 0; i<this.pop_size; i++) {
				if(rng.nextFloat() < 0.25){
					SMTWTP_Sol mutated = mutator.mutate(newPop.get(i));
					newPop.set(i, mutated);
				}
			}
			
			
			//Evaluating the generated offspring
			
			for(int i = 0; i<this.pop_size; i++) {
				try {
					this.evaluator.evaluate(newPop.get(i));
				}
				catch (Exception e) {
					System.out.println(newPop.get(i).getTaskNbList());
					System.out.println("EVAL FAILED");
				}
			}
			
			
			SMTWTP_Sol worst_new = newPop.get(0);
			int worst_fitness = worst_new.getFitness();
			SMTWTP_Sol best_old = actual.get(0);
			int best_fitness = best_old.getFitness();
			
			for(int i = 1; i<this.pop_size; i++) {
				if (newPop.get(i).getFitness() > worst_fitness){
					worst_new = newPop.get(i);
					worst_fitness = worst_new.getFitness();
				}
				if (actual.get(i).getFitness() < best_fitness){
					best_old = actual.get(i);
					best_fitness = best_old.getFitness();
				}
				
			}
			
			if (best_fitness < worst_fitness){
				newPop.remove(worst_new);
				newPop.add(best_old);
			}
			
			actual = newPop;
			
			evaluation_counter += pop_size;
			generation_counter += 1;
			
			
			
		}
		
		
		String sss = "";
		for (int i = 0; i < this.pop_size; i++){
			
			sss += actual.get(i).getFitness() + ";";
			
		}
		
		
		SMTWTP_Sol best_sol = actual.get(0);
		int best_fitness = best_sol.getFitness();
		
		for(int i = 1; i<this.pop_size; i++) {
			if (actual.get(i).getFitness() < best_fitness){
				best_sol = actual.get(i);
				best_fitness = best_sol.getFitness();
			}
			
		}
		
		
		return best_sol;
		
		
	}

}
