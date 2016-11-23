package crossover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import mutation.Swap_Mutation;

import solution.SMTWTP_Sol;

public class Order_Based_Crossover extends SMTWTP_Crossover {

	public Order_Based_Crossover(Random rng) {
		super(rng);
	}

	@Override
	public void generateOffsprings(SMTWTP_Sol parent1, SMTWTP_Sol parent2) {
		List<Integer> listp1 = parent1.getTaskNbList();
		List<Integer> listp2 = parent2.getTaskNbList();
		
		
		int sol_size = listp1.size();
		
		List<Integer> listo1 = new ArrayList<Integer>();
		
		List<Integer> listo2 = new ArrayList<Integer>();
		
		
		List<Integer> chosenPos = new ArrayList<Integer>();
		
		for(int i = 0; i<sol_size; i++){
			listo1.add(-1);
			listo2.add(-1);
			chosenPos.add(i);
		}
		Collections.shuffle(chosenPos, rng);
		for(int i = 0; i<sol_size/2; i++){
			listo1.set(chosenPos.get(i), listp2.get(chosenPos.get(i)));
			listo2.set(chosenPos.get(i), listp1.get(chosenPos.get(i)));
		}
		
		int o1counter = 0;
		int p1counter = 0;
		
		while (o1counter < sol_size && p1counter < sol_size){
			if (listo1.get(o1counter) == -1){
				int newcandidate = listp1.get(p1counter);
				if (listo1.contains(newcandidate)){
					p1counter++;
				}
				else {
					listo1.set(o1counter, newcandidate);
					o1counter++;
					p1counter++;
				}
			}
			else{
				o1counter++;
			}
		}
		
		int o2counter = 0;
		int p2counter = 0;
		
		while (o2counter < sol_size && p2counter < sol_size){
			if (listo2.get(o2counter) == -1){
				int newcandidate = listp2.get(p2counter);
				if (listo2.contains(newcandidate)){
					p2counter++;
				}
				else {
					listo2.set(o2counter, newcandidate);
					o2counter++;
					p2counter++;
				}
			}
			else{
				o2counter++;
			}
		}
		
		
		this.off1 = new SMTWTP_Sol(listo1);
		this.off2 = new SMTWTP_Sol(listo2);
		
		
	}
	
	public static void main(String[] args){
		Integer[] arr1 = {4,1,6,5,3,2,8,7};
		List<Integer> list1 = Arrays.asList(arr1);
		SMTWTP_Sol sol1 = new SMTWTP_Sol(list1);
		Integer[] arr2 = {1,7,4,8,2,6,5,3};
		List<Integer> list2 = Arrays.asList(arr2);
		SMTWTP_Sol sol2 = new SMTWTP_Sol(list2);
		Random r = new Random(42);
		Order_Based_Crossover obc = new Order_Based_Crossover(r);
		obc.generateOffsprings(sol1, sol2);
		System.out.println("\n");
		System.out.println(list1);
		System.out.println(obc.getOff1().getTaskNbList());
		System.out.println("\n");
		System.out.println(list2);
		System.out.println(obc.getOff2().getTaskNbList());
	}

}
