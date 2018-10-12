package me.personal.accessdatajpa.repo;

import me.personal.accessdatajpa.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
    This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
    CRUD refers Create, Read, Update, Delete
 * Created by zhongyi on 2018/9/23.
 */

public interface UserRepository extends CrudRepository<User, Integer> {

}