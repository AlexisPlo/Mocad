package neighboor;

import java.util.ArrayList;
import java.util.Collections;

import solution.SMTWTP_Sol;

public class SMTWTP_Insert implements Neighbourhood {

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
		rand_j.add(i_size);
		Collections.shuffle(rand_i);
		Collections.shuffle(rand_j);
		act_i = 0;
		act_j = 0;
	}

	
	@Override
	public SMTWTP_Sol next() {
		int ins_i = rand_i.get(act_i);
		int ins_j = rand_j.get(act_j); 
		ArrayList<Integer> newList = new ArrayList<Integer>(base.getTaskNbList());
		int temp = newList.remove(ins_i);
		if(ins_j == i_size)
			newList.add(temp);
		else
			newList.add(ins_j, temp);
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
			if(act_j>i_size){
				act_i++;
				act_j = 0;
			}
		}while(act_i<i_size && rand_i.get(act_i) == rand_j.get(act_j)  );
	}
}
