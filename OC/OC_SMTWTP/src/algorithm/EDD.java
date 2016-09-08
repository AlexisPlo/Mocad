package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import problem.SMTWTP;
import solution.SMTWTP_Sol;

public class EDD extends SMTWTP_Algo {



	public EDD(SMTWTP inst) {
		super(inst);
	}

	@Override
	public SMTWTP_Sol run() {
		ArrayList<Integer> tl = new ArrayList<Integer>();
		for(int i =0; i<inst.getInstanceSize(); i++){
			tl.add(i);
		}
		Collections.sort(tl, new Comparator<Integer>(){
			public int compare(Integer i1, Integer i2){
				if(inst.getTasks().get(i1).getDueTime() < inst.getTasks().get(i2).getDueTime()){
					return -1;
				}
				else{
					return 1;
				}
			}
		});
		return new SMTWTP_Sol(tl);
		
	}
	
	
	
}
