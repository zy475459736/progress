package me.personal.skills.yamlconfig;

/**
 * Created by zhongyi on 2018/7/24.
 */
public class ZookeeperConfiguration {

    private String quorum;

    private int sessionTimeoutMillis = 600_000;

    private int connectTimeoutMillis = 60_000;

    private int retryBaseSleepTimeMilliseconds = 1_000;

    private int retryMaxTries = 3;

    private String zkNamespace;

    public ZookeeperConfiguration(){}

    public ZookeeperConfiguration(String quorum, int sessionTimeoutMillis, int connectTimeoutMillis, int retryBaseSleepTimeMilliseconds, int retryMaxTries, String zkNamespace) {
        this.quorum = quorum;
        this.sessionTimeoutMillis = sessionTimeoutMillis;
        this.connectTimeoutMillis = connectTimeoutMillis;
        this.retryBaseSleepTimeMilliseconds = retryBaseSleepTimeMilliseconds;
        this.retryMaxTries = retryMaxTries;
        this.zkNamespace = zkNamespace;
    }

    public String getQuorum() {
        return quorum;
    }

    public void setQuorum(String quorum) {
        this.quorum = quorum;
    }

    public int getSessionTimeoutMillis() {
        return sessionTimeoutMillis;
    }

    public void setSessionTimeoutMillis(int sessionTimeoutMillis) {
        this.sessionTimeoutMillis = sessionTimeoutMillis;
    }

    public int getConnectTimeoutMillis() {
        return connectTimeoutMillis;
    }

    public void setConnectTimeoutMillis(int connectTimeoutMillis) {
        this.connectTimeoutMillis = connectTimeoutMillis;
    }

    public int getRetryBaseSleepTimeMilliseconds() {
        return retryBaseSleepTimeMilliseconds;
    }

    public void setRetryBaseSleepTimeMilliseconds(int retryBaseSleepTimeMilliseconds) {
        this.retryBaseSleepTimeMilliseconds = retryBaseSleepTimeMilliseconds;
    }

    public int getRetryMaxTries() {
        return retryMaxTries;
    }

    public void setRetryMaxTries(int retryMaxTries) {
        this.retryMaxTries = retryMaxTries;
    }

    public String getZkNamespace() {
        return zkNamespace;
    }

    public void setZkNamespace(String zkNamespace) {
        this.zkNamespace = zkNamespace;
    }
}
