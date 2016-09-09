package neighboor;

import solution.SMTWTP_Sol;

public interface Neighbourhood {

	public void init(SMTWTP_Sol base);
	public SMTWTP_Sol next();
	public boolean hasNext();
}
