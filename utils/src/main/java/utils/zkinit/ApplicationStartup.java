package utils.zkinit;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import utils.util.TimeUtil;
import utils.zkleader.PaasLeaderLatch;
import utils.zkleader.PaasLeaderListener;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.Set;

import static com.google.common.base.Preconditions.checkState;


@Slf4j
@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private CuratorFramework curatorFramework;

	@Autowired
	private PaasLeaderListener listener;

	private PaasLeaderLatch leader;
    @Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Set<LeaderLatchListener> listeners = Sets.newHashSet();

		try {
			listeners.add(listener);

			curatorFramework.start();
			final long start = System.currentTimeMillis();
		
			checkState(curatorFramework.getZookeeperClient().blockUntilConnectedOrTimedOut(),"did not connect to zookeeper");

			log.info("Connected to ZK after {}", TimeUtil.duration(start));

			leader = new PaasLeaderLatch(curatorFramework, listeners);

			leader.start();

		} catch (Exception e) {
			log.error("paas fail start leader!", e);
		}
	}

	@PreDestroy
	public void stop() {
		try {
			if (leader != null) {
				curatorFramework.close();
				leader.stop();
			}
		} catch (Exception e) {
			log.error("paas fail stop leader!", e);
		}
	}
}
