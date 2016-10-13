package algorithm;

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
	private int stop_criterion;
	private int generation_counter;
	private int evaluation_counter;
	



	public SimpleGA(SMTWTP inst, SMTWTP_PopInit initiator,
			SMTWTP_Select selector, SMTWTP_Crossover crosser,
			SMTWTP_Mutation mutator, SMTWTP_Replace replacer, int stop_criterion) {
		super(inst);
		this.initiator = initiator;
		this.selector = selector;
		this.crosser = crosser;
		this.mutator = mutator;
		this.replacer = replacer;
		this.stop_criterion = stop_criterion;
	}




	@Override
	public SMTWTP_Sol run() {
		
		SMTWTP_Pop actual;
		actual = initiator.generateInit(inst);
		
	}

}
