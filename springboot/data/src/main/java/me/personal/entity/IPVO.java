package me.personal.entity;

import me.personal.common.IPState;
import me.personal.skills.util.TimeUtil;

/**
 * Created by zhongyi on 2018/7/23.
 */
public class IPVO {
    private long id;
    private String host;
    private String ip;
    private IPState state;
    private String createTime;
    private String modifyTime;

    public IPVO(IPEntity entity){
        this.id = entity.getId();
        this.host = entity.getHost();
        this.ip = entity.getIp();
        this.state = IPState.getStateByCode(entity.getStatus());
        this.createTime = TimeUtil.convertDateToString(entity.getInsertTime());
        this.modifyTime = TimeUtil.convertDateToString(entity.getUpdateTime());
    }

    public IPVO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public IPState getState() {
        return state;
    }

    public void setState(IPState state) {
        this.state = state;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
}
