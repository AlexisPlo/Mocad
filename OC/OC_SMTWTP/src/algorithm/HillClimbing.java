package algorithm;

import neighboor.Neighbourhood;
import neighboor.SMTWTP_Exchange;
import neighboor.SMTWTP_Insert;
import neighboor.SMTWTP_Swap;
import problem.SMTWTP;
import solution.SMTWTP_Sol;

public class HillClimbing extends SMTWTP_Algo{
	
	private int select;
	private Neighbourhood nei;
	private SMTWTP_Algo init;

	public HillClimbing(SMTWTP inst, int select, int neighboor, int init){
		super(inst);
		this.select = select;
		switch(neighboor){
		case 0:
			nei = new SMTWTP_Insert();
			break;
		case 1:
			nei = new SMTWTP_Swap();
			break;
		case 2:
			nei = new SMTWTP_Exchange();
			break;
		}
		switch(init){
		case 0:
			this.init = new RandomSol(inst);
			break;
		case 1:
			this.init = new EDD(inst);
			break;
		case 2:
			this.init = new MDD(inst);
		}
	}

	@Override
	public SMTWTP_Sol run() {
		SMTWTP_Sol actual = this.init.run();
		boolean better = true;
		
		if(select == 1){
			
			
			int old_score = this.evaluator.evaluate(actual);
			while(better){
				int best_score = old_score;
				
				SMTWTP_Sol bestNei = actual;
				nei.init(actual);
				int i = 0;
				while(nei.hasNext()){
					SMTWTP_Sol challenger = nei.next();
					int new_score = this.evaluator.evaluate(challenger);
					if (new_score < best_score){
						bestNei = challenger;
						best_score = new_score;
					}
					i++;
				}
				System.out.println(i);
				if (best_score < old_score){
					actual = bestNei;
					old_score = best_score;
				}
				else
					better = false;
			}
		}
		
		else{
			int old_score = this.evaluator.evaluate(actual);
			while(better){
				int best_score = old_score;
				
				SMTWTP_Sol bestNei = actual;
				nei.init(actual);
				int i = 0;
				while(nei.hasNext()){
					SMTWTP_Sol challenger = nei.next();
					int new_score = this.evaluator.evaluate(challenger);
					if (new_score < best_score){
						bestNei = challenger;
						best_score = new_score;
						break;
					}
				}
				System.out.println(i);
				if (best_score < old_score){
					actual = bestNei;
					old_score = best_score;
				}
				else
					better = false;
			}
		}
		
		return actual;
	}
	
}
