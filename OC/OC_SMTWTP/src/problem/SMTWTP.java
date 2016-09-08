package problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SMTWTP {

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
					SMTWTP_Task singleTask = new SMTWTP_Task(i+1, procTimeList[i], weightList[i], dueTimeList[i]);
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
	
	public String toString(){
		
		String desc = "SMTWTP Instance of size " + this.instanceSize + "\n";
		for(SMTWTP_Task t: this.tasks){
			desc = desc + t + "\n";
		}
		return desc;
	}
	
	public static void main(String[] args){
		List<SMTWTP> instances = SMTWTP.readSMTWTPInstancesFile("wt100.txt");
		for(SMTWTP i: instances){
			System.out.println(i);
		}
	}
}
