package problem;

public class SMTWTP_Task {

	private int taskNb;
	private int procTime;
	private int weight;
	private int dueTime;
	
	public SMTWTP_Task(int taskNb, int procTime, int weight, int dueTime) {
		super();
		this.taskNb = taskNb;
		this.procTime = procTime;
		this.weight = weight;
		this.dueTime = dueTime;
	}
	
	

	public int getTaskNb() {
		return taskNb;
	}


	public void setTaskNb(int taskNb) {
		this.taskNb = taskNb;
	}



	public int getProcTime() {
		return procTime;
	}

	public void setProcTime(int procTime) {
		this.procTime = procTime;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getDueTime() {
		return dueTime;
	}

	public void setDueTime(int dueTime) {
		this.dueTime = dueTime;
	}
	
	
	public String toString(){
		String res = "Task " + this.taskNb;
		res = res + " ; " + this.procTime;
		res = res + " ; " + this.weight;
		res = res + " ; " + this.dueTime;
		return res;
	}
	
}
