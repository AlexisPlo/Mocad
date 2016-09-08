package algorithm;

import java.util.ArrayList;
import java.util.Collections;

import problem.SMTWTP;

import solution.SMTWTP_Sol;

public class RandomSol extends SMTWTP_Algo{

	
	public RandomSol(SMTWTP inst) {
		super(inst);
	}

	@Override
	public SMTWTP_Sol run() {

		ArrayList<Integer> nbList = new ArrayList<Integer>();
		for (int i = 0; i<inst.getInstanceSize(); i++ ){
			nbList.add(i);
		}
		Collections.shuffle(nbList);
		return new SMTWTP_Sol(nbList);
	}

}
