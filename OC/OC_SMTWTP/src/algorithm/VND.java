package algorithm;

import java.util.ArrayList;
import java.util.List;

import neighboor.Neighbourhood;
import neighboor.SMTWTP_Exchange;
import neighboor.SMTWTP_Insert;
import neighboor.SMTWTP_Swap;
import problem.SMTWTP;
import selection.Selector;
import solution.SMTWTP_Sol;

public class VND extends SMTWTP_Algo{
	
	
	private Selector select;
	private List<Neighbourhood> neis;
	private SMTWTP_Algo init;

	public VND(SMTWTP inst, Selector select, int config, SMTWTP_Algo init){
		super(inst);
		this.select = select;
		this.neis = new ArrayList<Neighbourhood>();
		
		switch(config){
		case 0:
			neis.add(new SMTWTP_Exchange());
			neis.add(new SMTWTP_Swap());
			neis.add(new SMTWTP_Insert());
			break;
		default:
			neis.add(new SMTWTP_Exchange());
			neis.add(new SMTWTP_Insert());
			neis.add(new SMTWTP_Swap());
			break;
		}
		this.init = init;
	}

	@Override
	public SMTWTP_Sol run() {
		SMTWTP_Sol actual = this.init.run();

		SMTWTP_Sol newSol = null;
		while(true) {
			for(int i = 0; i < neis.size(); i++){
				try {
				newSol = select.selectSol(actual, neis.get(i), this.evaluator);
				}
				catch (Exception e) {
					System.out.println("EVAL FAILED");
				}
				if (newSol != actual)
					break;
			}
			
			if (newSol == actual)
				break;
			actual = newSol;
		}
		
		return actual;
	}

}
