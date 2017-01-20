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
	private SMTWTP_Sol initSol;
	private int evalCounter;

	public HillClimbing(SMTWTP inst, Selector select, Neighbourhood neighboor, SMTWTP_Algo init){
		super(inst);
		this.select = select;
		this.nei = neighboor;
		this.initSol = init.run();
	}
	
	public HillClimbing(SMTWTP inst, Selector select, Neighbourhood neighboor, SMTWTP_Sol initSol){
		super(inst);
		this.select = select;
		this.nei = neighboor;
		this.initSol = initSol;
	}
	
	

	public int getEvalCounter() {
		return evalCounter;
	}

	@Override
	public SMTWTP_Sol run() {
		this.evalCounter = 0;
		SMTWTP_Sol actual = this.initSol;
		
		while(true) {
			SMTWTP_Sol newSol = null;
			try {
				newSol = select.selectSol(actual, nei, this.evaluator);
			}
			catch (IllegalStateException e) {
				System.out.println("EVAL FAILED");
			}
			this.evalCounter += select.getEvaluation_counter();
			if (newSol == actual)
				break;
			actual = newSol;
		}
		
		return actual;
	}
	
}
