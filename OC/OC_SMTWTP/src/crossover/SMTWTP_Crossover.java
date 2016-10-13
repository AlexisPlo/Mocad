package crossover;

import solution.SMTWTP_Sol;

public abstract class SMTWTP_Crossover {
	
	protected SMTWTP_Sol off1;
	protected SMTWTP_Sol off2;
	
	public SMTWTP_Sol getOff1() {
		return off1;
	}

	public SMTWTP_Sol getOff2() {
		return off2;
	}

	public abstract void generateOffsprings(SMTWTP_Sol parent1, SMTWTP_Sol parent2);
	

}
