package perturbation;

import java.util.ArrayList;
import java.util.Random;

import solution.SMTWTP_Sol;

public class SMTWTP_PerturbInsert implements Perturbation{
	
	private int nbMoves;
	
	public SMTWTP_PerturbInsert(int nbMoves){
		this.nbMoves = nbMoves;
	}

	@Override
	public SMTWTP_Sol applyPerturbation(SMTWTP_Sol initial) {
		int i_size = initial.getTaskNbList().size();
		Random rand = new Random();
		SMTWTP_Sol actual = initial;
		
		for (int i = 0; i<nbMoves; i++){
			
			int ins_i = rand.nextInt(i_size);
			int ins_j = rand.nextInt(i_size+1);
			while(ins_j == ins_i){
				ins_j = rand.nextInt(i_size+1);
			}
			ArrayList<Integer> newList = new ArrayList<Integer>(actual.getTaskNbList());
			int temp = newList.remove(ins_i);
			if(ins_j == i_size)
				newList.add(temp);
			else
				newList.add(ins_j, temp);
			actual = new SMTWTP_Sol(newList);
			
			
		}
		
		return actual;
		
		
	}

}
