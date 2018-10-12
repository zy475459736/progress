package me.personal.accessdatajpa.repo;

import me.personal.accessdatajpa.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by zhongyi on 2018/9/22.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}