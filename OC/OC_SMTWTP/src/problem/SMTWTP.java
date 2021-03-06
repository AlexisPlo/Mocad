package problem;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import crossover.Order_Based_Crossover;
import mutation.Swap_Mutation;

import perturbation.SMTWTP_PerturbInsert;
import popInit.Hybrid_Initiator;

import neighboor.SMTWTP_Exchange;
import neighboor.SMTWTP_Insert;
import neighboor.SMTWTP_Swap;

import evaluation.SMTWTP_Eval;

import select.Tournament_Selector;
import selection.Best_Improv;
import selection.First_Improv;
import solution.SMTWTP_Sol;

import algorithm.EDD;
import algorithm.HillClimbing;
import algorithm.ILS;
import algorithm.MDD;
import algorithm.RandomSol;
import algorithm.SimpleGA;
import algorithm.VND;

public class SMTWTP implements Instance{

	private int instanceSize;
	private List<SMTWTP_Task> tasks;
	
	public SMTWTP(int instanceSize, List<SMTWTP_Task> tasks){
		this.instanceSize = instanceSize;
		this.tasks = tasks;
	}
	
	
	//Parsing instances file
	public static List<SMTWTP> readSMTWTPInstancesFile(String filename, int i_size){

		ArrayList<SMTWTP> instanceList = new ArrayList<SMTWTP>();
		
		try{
			Scanner sc = new Scanner(new FileReader(filename));
			//Looping over instances
		
			while (sc.hasNextInt()){
				int[] procTimeList = new int[i_size];
				int[] weightList = new int[i_size];
				int[] dueTimeList = new int[i_size];
				for (int i = 0; i < i_size; i++){
					procTimeList[i] = sc.nextInt();
				}
				for (int i = 0; i < i_size; i++){
					weightList[i] = sc.nextInt();
				}
				for (int i = 0; i < i_size; i++){
					dueTimeList[i] = sc.nextInt();
				}
				
				ArrayList<SMTWTP_Task> newTasks = new ArrayList<SMTWTP_Task>();
				
				for (int i = 0; i < i_size; i++){
					SMTWTP_Task singleTask = new SMTWTP_Task(i, procTimeList[i], weightList[i], dueTimeList[i]);
					newTasks.add(singleTask);
				}
				SMTWTP newInstance = new SMTWTP(i_size, newTasks);
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
		List<SMTWTP> instances = SMTWTP.readSMTWTPInstancesFile("wt100.txt", 100);
//		for(SMTWTP i: instances){
//			System.out.println(i);
//		}
		Random r = new Random(42);
		
		for(int i = 0; i<20; i++){
			try{
				SMTWTP_Eval eval = new SMTWTP_Eval(instances.get(i));
				HillClimbing algo = new HillClimbing(instances.get(i), new First_Improv(), new SMTWTP_Insert(), 0);
				//VND algo = new VND(instances.get(i), new First_Improv(), 0, new MDD(instances.get(i)));
				//MDD algo = new MDD(instances.get(i));
				SMTWTP_Sol sol1 = algo.run();
				System.out.println("Instance " + i );
				System.out.println("La fonction de cout de la solution trouvée est: " + eval.evaluate(sol1));
				System.out.println(algo.getEvalCounter());
				ILS algo2 = new ILS(instances.get(i), new First_Improv(), new SMTWTP_Swap(), new SMTWTP_PerturbInsert(5), new RandomSol(instances.get(i), r), 500000);
				SMTWTP_Sol sol2 = algo2.run();
				System.out.println("Instance " + i );
				System.out.println("La fonction de cout de la solution trouvée est: " + eval.evaluate(sol2));
				System.out.println(algo2.getEvalCounter());
				/*SimpleGA algo2 = new SimpleGA(instances.get(i), new Hybrid_Initiator(r),
						new Tournament_Selector(2, r, eval), new Order_Based_Crossover(r), new Swap_Mutation(r), null, 50, 1000000);
				SMTWTP_Sol sol2 = algo2.run();
				System.out.println("Instance " + i );
				System.out.println("La fonction de cout de la solution trouvée est: " + eval.evaluate(sol2));
			*/}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
