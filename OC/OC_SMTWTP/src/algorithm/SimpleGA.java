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
		
		Random rng = new Random();
		
		SMTWTP_Pop actual;
		actual = initiator.generateInit(inst);
		
		while(evaluation_counter < max_eval){
			SMTWTP_Pop newPop = new SMTWTP_Pop();
			
			//Generating offspring via crossover
			for(int i = 0; i<this.pop_size / 2; i++){
				
				//Selecting parents
				SMTWTP_Sol p1 = selector.select(actual);
				SMTWTP_Sol p2 = selector.select(actual);
				
				//Crossover
				while (p2 == p1){
					p2 = selector.select(actual);
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
				this.evaluator.evaluate(newPop.get(i));
			}
			
			SMTWTP_Sol worst_new;
			int worst_fitness = 0;
			SMTWTP_Sol best_old;
			int best_fitness = Integer.MAX_VALUE;
			
			for(int i = 0; i<this.pop_size; i++) {
				if (newPop.get(i).getFitness() > worst_fitness){
					worst_new = newPop.get(i);
					worst_fitness = worst_new.getFitness();
				}
				if (actual.get(i).getFitness() < best_fitness){
					best_old = actual.get(i);
					best_fitness = best_old.getFitness();
				}
				
			}
			
		}
		
		
		return null;
		
		
	}

}
