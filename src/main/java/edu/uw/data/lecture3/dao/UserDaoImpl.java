package edu.uw.data.lecture3.dao;

import edu.uw.data.lecture3.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * simple single-table Jdbc example with try-resources and datasource
 */
@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);


    @PersistenceContext
    private EntityManager em;


    public User findById(Integer id) {
        return em.find(User.class, id);
    }

    //@Transactional(readOnly = true)
    public List<User> findAll() {
        return em.createQuery("FROM User").getResultList();  // also " SELECT u FROM User u"""
    }


    @Override
    public User findByUsername(String uname) {
        return (User) em.createQuery(
                "SELECT u FROM User u WHERE u.userName LIKE :uname")
                .setParameter("uname", uname)
                .getSingleResult();
    }

    @Override
    //@Transactional(readOnly = true)
    public User save(User user) {
        if (user.getId() == null) { //insert
            em.persist(user);
        } else { //update
            em.merge(user);
        }
        // em.flush();
        log.info("saved " + user.getId());
        return user;
    }


    public void deleteUserById(Integer id) {
        User user = em.find(User.class, 1);
        em.remove(user);
    }
}
