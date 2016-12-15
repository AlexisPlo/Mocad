package neighbour;

import solution.MTSP_Sol;


public interface MTSP_Neighbourhood {

	public void init(MTSP_Sol base);
	public MTSP_Sol next();
	public boolean hasNext();
}
