package me.personal.skills.zkleader;

import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.springframework.stereotype.Component;

/**
 * 异步监听LeaderLatch的状态，
 * 即随着hasLeadership状态的变化，isLeader()和notLeader()方法分别会被调用。
 *
 * 注意！isLeader()方法被调用仅仅代表“成为过Leader”，不代表这个状态会保持。
 *
 * */
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
