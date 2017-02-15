package algorithm;

import java.util.Random;

import evaluation.SMTWTP_Eval;
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
	private int algoInit;

	public HillClimbing(SMTWTP inst, Selector select, Neighbourhood neighboor, int algoInit){
		super(inst);
		this.select = select;
		this.nei = neighboor;
		this.init(inst);
	}
	
	private void init(SMTWTP inst) {
		switch(this.algoInit){
		case 0:
			this.initSol = new RandomSol(inst, new Random(1)).run();
			break;
		case 1:
			this.initSol = new EDD(inst).run();
			break;
		default:
			this.initSol = new MDD(inst).run();
			break;
		}
	}

	public HillClimbing(SMTWTP inst, Selector select, Neighbourhood neighboor, SMTWTP_Sol initSol){
		super(inst);
		this.select = select;
		this.nei = neighboor;
		this.initSol = initSol;
	}
	
	@Override
	public void setInstance(SMTWTP inst){
		this.inst = inst;
		this.evaluator = new SMTWTP_Eval(inst);
		this.init(inst);
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
