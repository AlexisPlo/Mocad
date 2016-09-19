package neighboor;

import java.util.ArrayList;
import java.util.Collections;

import solution.SMTWTP_Sol;

public class SMTWTP_Exchange implements Neighbourhood{

	private SMTWTP_Sol base;
	private ArrayList<Integer> rand_i;
	private int act_i;
	private int i_size;
	
	@Override
	public void init(SMTWTP_Sol base) {
		this.base = base;
		this.i_size = base.getTaskNbList().size() - 1;
		rand_i = new ArrayList<Integer>();
		for(int i = 0; i < i_size; i++){
			rand_i.add(i);
		}
		Collections.shuffle(rand_i);
		act_i = 0;
	}

	
	@Override
	public SMTWTP_Sol next() {
		int exch_i = rand_i.get(act_i);
		ArrayList<Integer> newList = new ArrayList<Integer>(base.getTaskNbList());
		int temp = newList.get(exch_i);
		newList.set(exch_i, newList.get(exch_i+1));
		newList.set(exch_i+1, temp);
		act_i++;
		return new SMTWTP_Sol(newList);
	}


	@Override
	public boolean hasNext() {
		return act_i < i_size;
	}

}
