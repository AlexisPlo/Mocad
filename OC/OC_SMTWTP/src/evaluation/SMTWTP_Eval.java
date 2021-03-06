package evaluation;

import java.util.HashSet;

import problem.SMTWTP;
import problem.SMTWTP_Task;
import solution.SMTWTP_Sol;

public class SMTWTP_Eval {

	
		private SMTWTP inst;

		public SMTWTP_Eval(SMTWTP inst) {
			super();
			this.inst = inst;
		}
		
		public int evaluate(SMTWTP_Sol sol) throws IllegalStateException{
			int sol_size = sol.getTaskNbList().size();
			HashSet<Integer> se = new HashSet<Integer>();
			se.addAll(sol.getTaskNbList());
			int set_size = se.size();
			if(set_size != sol_size){
				throw new IllegalStateException("Evaluation failed");
			}
			int actual_time = 0;
			int total_tardiness = 0;
			for(Integer i: sol.getTaskNbList()){
				SMTWTP_Task t = this.inst.getTasks().get(i);
				actual_time += t.getProcTime();
				if(actual_time > t.getDueTime()){
					total_tardiness += t.getWeight() * (actual_time - t.getDueTime());
				}
				
			}
			sol.setFitness(total_tardiness);
			return total_tardiness;
		}
}
