package me.personal.entity;

import me.personal.skills.util.TimeUtil;

/**
 * Created by zhongyi on 2018/7/23.
 */
public class SubnetVO {
    private long id;
    private String host;
    private String subnet;
    private String createTime;
    private String modifyTime;

    public SubnetVO() {
    }

    public SubnetVO(SubnetEntity entity){
        this.id = entity.getId();
        this.host = entity.getHost();
        this.subnet = entity.getSubnet();
        this.createTime = TimeUtil.convertDateToString(entity.getInsertTime());
        this.modifyTime = TimeUtil.convertDateToString(entity.getUpdateTime());
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

    public String getSubnet() {
        return subnet;
    }

    public void setSubnet(String subnet) {
        this.subnet = subnet;
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
