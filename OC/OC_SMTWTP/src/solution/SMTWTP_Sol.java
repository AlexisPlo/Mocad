package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SMTWTP_Sol {

	private List<Integer> taskNbList;
	private int fitness;

	public SMTWTP_Sol(List<Integer> taskNbList) {
		super();
		this.taskNbList = taskNbList;
	}
	
	

	public int getFitness() {
		return fitness;
	}



	public void setFitness(int fitness) {
		this.fitness = fitness;
	}



	public List<Integer> getTaskNbList() {
		return taskNbList;
	}

	public void setTaskNbList(List<Integer> taskNbList) {
		this.taskNbList = taskNbList;
	}
	
}
