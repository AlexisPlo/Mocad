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
		for(int i = 0; i<opt_j-opt_i; i++){
			newList.set(opt_i + i, base.get(opt_j-1-i));
		}
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
	
	public static void main(String[] args){
		MTSP_Sol sss = new MTSP_Sol();
		sss.add(1);
		sss.add(2);
		sss.add(3);
		sss.add(4);
		sss.add(5);
		sss.add(6);
		sss.add(7);
		sss.add(8);
		sss.add(9);
		sss.add(10);
		sss.add(11);
		sss.add(12);
		
		MTSP_TwoOpt opt = new MTSP_TwoOpt();
		opt.init(sss);
		System.out.println(sss);
		sss = opt.next();
		System.out.println(sss);
		sss = opt.next();
		System.out.println(sss);
		sss = opt.next();
		System.out.println(sss);
		opt.next();
		
	}

}
