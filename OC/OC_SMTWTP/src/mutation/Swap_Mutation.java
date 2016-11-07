package mutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import solution.SMTWTP_Sol;

public class Swap_Mutation implements SMTWTP_Mutation {

	private Random rng;
	
	public Swap_Mutation(Random rng){
		this.rng = rng;
	}
	@Override
	public SMTWTP_Sol mutate(SMTWTP_Sol parent) {

		SMTWTP_Sol newSol = new SMTWTP_Sol(parent.getTaskNbList());
		
		List<Integer> theList = newSol.getTaskNbList();
		int sol_size = theList.size();
		
		int rnd1 = rng.nextInt(sol_size);
		int rnd2 = rng.nextInt(sol_size);
		
		while(rnd2 == rnd1){
			rnd2 = rng.nextInt(sol_size);
		}
		
		int changed1 = theList.get(rnd1);
		int changed2 = theList.get(rnd2);
		theList.set(rnd1, changed2);
		theList.set(rnd2, changed1);
				
		return newSol;
	}
	
	public static void main(String[] args){
		Integer[] arr1 = {4,1,6,5,3,2};
		List<Integer> list1 = Arrays.asList(arr1);
		SMTWTP_Sol sol1 = new SMTWTP_Sol(list1);
		Random r = new Random();
		Swap_Mutation sm = new Swap_Mutation(r);
		SMTWTP_Sol mutated = sm.mutate(sol1);
		
		System.out.println(mutated.getTaskNbList());
	}

}
