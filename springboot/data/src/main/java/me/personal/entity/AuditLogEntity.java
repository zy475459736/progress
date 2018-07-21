package me.personal.entity;

import javax.persistence.*;

/**
 * Created by zhongyi on 2018/7/21.
 */
@Cacheable(false)
@Entity
@Table(name = "audit_log")
public class AuditLogEntity  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "client_ip")
    private String clientIp;

    @Column(name = "http_method")
    private String httpMethod;

    @Column(name = "http_uri")
    private String httpUri;

    @Column(name = "class_method")
    private String classMethod;

    @Column(name = "class_method_args")
    private String classMethodArgs;

    @Column(name = "class_method_return")
    private String classMethodReturn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
