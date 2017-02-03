package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import problem.SMTWTP;

import solution.SMTWTP_Sol;

public class RandomSol extends SMTWTP_Algo{

	private Random rng;
	
	public RandomSol(SMTWTP inst, Random rng) {
		super(inst);
		this.rng = rng;
	}

	@Override
	public SMTWTP_Sol run() {

		ArrayList<Integer> nbList = new ArrayList<Integer>();
		for (int i = 0; i<inst.getInstanceSize(); i++ ){
			nbList.add(i);
		}
		Collections.shuffle(nbList, rng);
		return new SMTWTP_Sol(nbList);
	}

}