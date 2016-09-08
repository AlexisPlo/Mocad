package algorithm;

import java.util.ArrayList;

import problem.SMTWTP;
import problem.SMTWTP_Task;
import solution.SMTWTP_Sol;

public class MDD extends SMTWTP_Algo {



	public MDD(SMTWTP inst) {
		super(inst);
	}

	@Override
	public SMTWTP_Sol run() {

		ArrayList<Integer> tl = new ArrayList<Integer>();
		int actual_time = 0;
		
		ArrayList<SMTWTP_Task> remaining_tasks = new ArrayList<SMTWTP_Task>(inst.getTasks());
		
		for(int t = 0; t<inst.getInstanceSize(); t++){
		
			ArrayList<Integer> mdd = new ArrayList<Integer>();
			for(int i = 0; i<remaining_tasks.size(); i++){
				int realtime = actual_time + remaining_tasks.get(i).getProcTime();
				if (realtime > remaining_tasks.get(i).getDueTime())
					mdd.add(realtime);
				else
					mdd.add(remaining_tasks.get(i).getDueTime());
			}
			int min_index = 0;
			int min_time = -1;
			for(int i = 0; i<remaining_tasks.size(); i++){
				if (mdd.get(i) < min_time || min_time == -1){
					min_time = mdd.get(i);
					min_index = i;
				}
			}
			actual_time += remaining_tasks.get(min_index).getProcTime();
			tl.add(remaining_tasks.get(min_index).getTaskNb());
			remaining_tasks.remove(min_index);
		
		}
		
		return new SMTWTP_Sol(tl);
		
	}
	
	
}