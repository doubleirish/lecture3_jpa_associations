package edu.uw.data.lecture3.dao;

import edu.uw.data.lecture3.model.User;

import java.util.List;

/**
 * Created by credmond on 03/03/15.
 */
public interface UserDao {

    // CRUD :  IInsert  and update
    User save(User user);


    // Queries
    User findById(Integer id);

    User findByUsername(String username);

    List<User> findAll();

    void deleteUserById(Integer id);

}
