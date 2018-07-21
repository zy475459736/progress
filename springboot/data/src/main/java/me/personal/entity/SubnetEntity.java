package me.personal.entity;

import javax.persistence.*;

@Cacheable(false)
@Entity
@Table(name = "ip_subnet")
public class SubnetEntity  extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "host")
    private String host;

    @Basic
    @Column(name = "subnet")
    private String subnet;

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
}