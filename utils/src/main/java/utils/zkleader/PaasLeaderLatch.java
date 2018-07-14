package utils.zkleader;


import utils.util.IPUtil;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;

import javax.annotation.PreDestroy;
import java.util.Set;

public class PaasLeaderLatch extends LeaderLatch {

    private static final String LEADER_PATH = "/leader";
  
    public PaasLeaderLatch(
        final CuratorFramework curatorFramework, final Set<LeaderLatchListener> listeners) throws Exception {
        super(curatorFramework, LEADER_PATH, IPUtil.getLocalIP());

        for (LeaderLatchListener listener : listeners) {
            addListener(listener);
        }
    }

    @PreDestroy
    public void stop() throws Exception {
        super.close();
    }

}