package me.personal.accessdatajpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by zhongyi on 2018/9/22.
 */
//在缺省@Table的情况下
//jpa 默认 该entity和Table Customer存在着映射关系
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)//表示自增
    private Long id;

    //在缺省注解的情况下，
    //jpa 默认 they’ll be mapped to columns that share the same name as the properties themselves.
    private String firstName;
    private String lastName;

    protected Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
