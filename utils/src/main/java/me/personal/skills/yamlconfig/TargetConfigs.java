package me.personal.skills.yamlconfig;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhongyi on 2018/7/24.
 */

public class TargetConfigs {
    private long askDriverToKillTasksAgainAfterMillis = TimeUnit.MINUTES.toMillis(5);

    @NotNull
    private int cooldownAfterFailures = 5;

    @NotNull
    private long cooldownExpiresAfterMinutes = 30;

    @NotNull
    private int logFetchCoreThreads = 3;

    @NotNull
    private int logFetchMaxThreads = 25;

    @NotNull
    private long healthcheckTimeoutSeconds = 5;

    @NotNull
    private long healthcheckIntervalSeconds = 5;

    @NotNull
    private long deployTimeoutAfterMinutes = 2;

    private boolean sandboxDefaultsToTaskId = true;

    private long sandboxHttpTimeoutMillis = TimeUnit.SECONDS.toMillis(2);

//    @JsonProperty("ui")
//    @Valid
//    private UIConfiguration uiConfiguration = new UIConfiguration();

//    @JsonProperty("mesos")
//    @Valid
//    private MesosConfiguration mesosConfiguration;

//    @JsonProperty("network")
//    @Valid
//    private NetworkConfiguration networkConfiguration = new NetworkConfiguration();


    @JsonProperty("zookeeper")
    @Valid
    private ZookeeperConfiguration zooKeeperConfiguration;
}
