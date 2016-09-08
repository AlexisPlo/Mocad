package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SMTWTP_Sol {

	private List<Integer> taskNbList;

	public SMTWTP_Sol(List<Integer> taskNbList) {
		super();
		this.taskNbList = taskNbList;
	}

	public List<Integer> getTaskNbList() {
		return taskNbList;
	}

	public void setTaskNbList(List<Integer> taskNbList) {
		this.taskNbList = taskNbList;
	}
	
	public static SMTWTP_Sol randomSolution(int instanceSize){
		ArrayList<Integer> nbList = new ArrayList<Integer>();
		for (int i = 0; i<instanceSize; i++ ){
			nbList.add(i);
		}
		Collections.shuffle(nbList);
		return new SMTWTP_Sol(nbList);
	}
}
