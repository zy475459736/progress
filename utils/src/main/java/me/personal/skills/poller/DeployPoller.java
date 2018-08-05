package me.personal.skills.poller;

import lombok.extern.slf4j.Slf4j;
import me.personal.skills.util.TimeUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Scope("singleton")
public class DeployPoller extends BasePoller {

	public DeployPoller() {
		super("DeployPoller", 1000 * 5);
	}

	@Override
	public void process() {

		long start = System.currentTimeMillis();

		log.info("DeployPoller cost {}  ms ", TimeUtil.duration(start));
	}

}
