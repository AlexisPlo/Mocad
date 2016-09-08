package problem;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import evaluation.SMTWTP_Eval;

import solution.SMTWTP_Sol;

import algorithm.EDD;
import algorithm.RandomSol;

public class SMTWTP implements Instance{

	private int instanceSize;
	private List<SMTWTP_Task> tasks;
	
	public SMTWTP(int instanceSize, List<SMTWTP_Task> tasks){
		this.instanceSize = instanceSize;
		this.tasks = tasks;
	}
	
	
	//Parsing instances file
	public static List<SMTWTP> readSMTWTPInstancesFile(String filename){

		ArrayList<SMTWTP> instanceList = new ArrayList<SMTWTP>();
		
		try{
			Scanner sc = new Scanner(new FileReader(filename));
			//Looping over instances
		
			while (sc.hasNextInt()){
				int[] procTimeList = new int[100];
				int[] weightList = new int[100];
				int[] dueTimeList = new int[100];
				for (int i = 0; i < 100; i++){
					procTimeList[i] = sc.nextInt();
				}
				for (int i = 0; i < 100; i++){
					weightList[i] = sc.nextInt();
				}
				for (int i = 0; i < 100; i++){
					dueTimeList[i] = sc.nextInt();
				}
				
				ArrayList<SMTWTP_Task> newTasks = new ArrayList<SMTWTP_Task>();
				
				for (int i = 0; i < 100; i++){
					SMTWTP_Task singleTask = new SMTWTP_Task(i, procTimeList[i], weightList[i], dueTimeList[i]);
					newTasks.add(singleTask);
				}
				SMTWTP newInstance = new SMTWTP(100, newTasks);
				instanceList.add(newInstance);
			}
			sc.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return instanceList;
		
	}
	
	
	
	public int getInstanceSize() {
		return instanceSize;
	}


	public void setInstanceSize(int instanceSize) {
		this.instanceSize = instanceSize;
	}


	public List<SMTWTP_Task> getTasks() {
		return tasks;
	}


	public void setTasks(List<SMTWTP_Task> tasks) {
		this.tasks = tasks;
	}


	public String toString(){
		
		String desc = "SMTWTP Instance of size " + this.instanceSize + "\n";
		for(SMTWTP_Task t: this.tasks){
			desc = desc + t + "\n";
		}
		return desc;
	}
	
	public static void main(String[] args){
		List<SMTWTP> instances = SMTWTP.readSMTWTPInstancesFile("wt100.txt");
//		for(SMTWTP i: instances){
//			System.out.println(i);
//		}
		
		for(int i = 0; i<125; i++){
			SMTWTP_Eval eval = new SMTWTP_Eval(instances.get(i));
			EDD algo = new EDD(instances.get(i));
			SMTWTP_Sol sol1 = algo.run();
			System.out.println("Instance " + i + "\n");
			System.out.println("La fonction de cout de la solution trouvée est: " + eval.evaluate(sol1));
		}
	}
}
