package neighboor;

import java.util.ArrayList;
import java.util.Collections;

import solution.SMTWTP_Sol;

public class SMTWTP_Swap implements Neighbourhood {

	private SMTWTP_Sol base;
	private ArrayList<Integer> rand_i;
	private ArrayList<Integer> rand_j;
	private int act_i;
	private int act_j;
	private int i_size;
	
	@Override
	public void init(SMTWTP_Sol base) {
		this.base = base;
		this.i_size = base.getTaskNbList().size();
		rand_i = new ArrayList<Integer>();
		rand_j = new ArrayList<Integer>();
		for(int i = 0; i < i_size; i++){
			rand_i.add(i);
			rand_j.add(i);
		}
		Collections.shuffle(rand_i);
		Collections.shuffle(rand_j);
		act_i = 0;
		act_j = 0;
	}

	
	@Override
	public SMTWTP_Sol next() {
		int swap_i = rand_i.get(act_i);
		int swap_j = rand_j.get(act_j);
		ArrayList<Integer> newList = new ArrayList<Integer>(base.getTaskNbList());
		int temp = newList.get(swap_i);
		newList.set(swap_i, newList.get(swap_j));
		newList.set(swap_j, temp);
		this.next_pair();
		return new SMTWTP_Sol(newList);
	}


	@Override
	public boolean hasNext() {
		return act_i < i_size;
	}

	private void next_pair(){
		do{
			act_j++;
			if(act_j>=i_size){
				act_i++;
				act_j = 0;
			}
		}while(act_i<i_size && rand_i.get(act_i) == rand_j.get(act_j)  );
	}
}
