package crossover;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import solution.SMTWTP_Sol;

public class Order_Based_Crossover extends SMTWTP_Crossover {

	public Order_Based_Crossover(Random rng) {
		super(rng);
	}

	@Override
	public void generateOffsprings(SMTWTP_Sol parent1, SMTWTP_Sol parent2) {
		List<Integer> listp1 = parent1.getTaskNbList();
		List<Integer> listremain1 = new ArrayList<Integer>(listp1);
		List<Integer> listp2 = parent2.getTaskNbList();
		List<Integer> listremain2 = new ArrayList<Integer>(listp2);
		
		
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
		System.out.println(chosenPos);
		for(int i = 0; i<sol_size/2; i++){
			listo1.set(chosenPos.get(i), listp2.get(chosenPos.get(i)));
			listo2.set(chosenPos.get(i), listp1.get(chosenPos.get(i)));
		}
			
	}

}
