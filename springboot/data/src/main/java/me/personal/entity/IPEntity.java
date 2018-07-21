package me.personal.entity;

import javax.persistence.*;

/**
 * Created by zhongyi on 2018/7/21.
 */
@Cacheable(false)
@Entity
@Table(name = "ip_pool")
public class IPEntity  extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "host")
    private String host;

    @Basic
    @Column(name = "ip")
    private String ip;

    @Basic
    @Column(name = "status")
    private int status;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}