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
		SMTWTP_Sol initial = this.init.run();
		boolean better = true;
		
		if(select == 1){
			
			SMTWTP_Sol actual = initial;
			while(better){
				int best = this.evaluator.evaluate(actual);
				nei.init(actual);
				while(nei.hasNext()){
					SMTWTP_Sol challenger = nei.next();
					int new_score = this.evaluator.evaluate(challenger);
				}
			}
		}
		
		else{
			
		}
		
		return null;
	}
	
}
