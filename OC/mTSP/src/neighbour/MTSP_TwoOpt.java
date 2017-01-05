package neighbour;

import java.util.ArrayList;
import java.util.Collections;

import solution.MTSP_Sol;


public class MTSP_TwoOpt implements MTSP_Neighbourhood{
	
	
	private MTSP_Sol base;
	private ArrayList<Integer> rand_i;
	private ArrayList<Integer> rand_j;
	private int act_i;
	private int act_j;
	private int i_size;

	@Override
	public void init(MTSP_Sol base) {
		this.base = base;
		this.i_size = base.size();
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
	public MTSP_Sol next() {
		int opt_i = rand_i.get(act_i);
		int opt_j = rand_j.get(act_j); 
		ArrayList<Integer> newList = new ArrayList<Integer>(base);
		int temp = newList.remove(ins_i);
		if(ins_j == i_size)
			newList.add(temp);
		else
			newList.add(ins_j, temp);
		this.next_pair();
		return new MTSP_Sol(newList);
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
		}while(act_i<i_size && Math.abs(rand_i.get(act_i) - rand_j.get(act_j)) > 1   );
	}

}
