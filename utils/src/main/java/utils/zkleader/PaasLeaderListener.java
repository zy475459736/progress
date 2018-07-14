package utils.zkleader;


import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaasLeaderListener implements LeaderLatchListener {


	private volatile boolean master;

	public PaasLeaderListener() {
		this.master = false;
	}

	@Override
	public void isLeader() {

		master = true;

	}

	public boolean isMaster() {
		return master;
	}


	@Override
	public void notLeader() {

		master = false;

	}


}
