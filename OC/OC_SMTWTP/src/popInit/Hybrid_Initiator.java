package popInit;

import java.util.Random;

import algorithm.MDD;
import algorithm.RandomSol;

import problem.SMTWTP;
import solution.SMTWTP_Pop;
import solution.SMTWTP_Sol;

public class Hybrid_Initiator implements SMTWTP_PopInit{

	private Random rng;
	
	public Hybrid_Initiator(Random rng){
		this.rng = rng;
	}
	
	
	public SMTWTP_Pop generateInit(SMTWTP inst, int pop_size) {
		
		SMTWTP_Pop newPop = new SMTWTP_Pop();
		
		MDD mdd = new MDD(inst);
		SMTWTP_Sol solAdd = mdd.run();
		newPop.add(solAdd);
		
		RandomSol rs = new RandomSol(inst, rng);
		for(int i = 0; i < pop_size - 1; i++){
			solAdd = rs.run();
			newPop.add(solAdd);
		}
		
		
		
		return newPop;
	}
}
