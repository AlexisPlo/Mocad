package algorithm;

import neighboor.Neighbourhood;
import neighboor.SMTWTP_Exchange;
import neighboor.SMTWTP_Insert;
import neighboor.SMTWTP_Swap;
import problem.SMTWTP;
import selection.Selector;
import solution.SMTWTP_Sol;

public class HillClimbing extends SMTWTP_Algo{
	
	private Selector select;
	private Neighbourhood nei;
	private SMTWTP_Algo init;

	public HillClimbing(SMTWTP inst, Selector select, Neighbourhood neighboor, SMTWTP_Algo init){
		super(inst);
		this.select = select;
		this.nei = neighboor;
		this.init = init;
	}

	@Override
	public SMTWTP_Sol run() {
		SMTWTP_Sol actual = this.init.run();

		
		while(true) {
			SMTWTP_Sol newSol = select.selectSol(actual, nei, this.evaluator);
			if (newSol == actual)
				break;
			actual = newSol;
		}
		
		return actual;
	}
	
}
