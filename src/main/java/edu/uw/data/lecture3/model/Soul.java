package edu.uw.data.lecture3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * bi directional one to one , a user has one soul, a soul belongs to just one user.
 * USERS table has a FK to SOUL
 */
@Entity
@Table(name = "SOUL")
public class Soul {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    //
    @OneToOne(mappedBy = "soul")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Soul{" +
                "id=" + id +
                '}';
    }


}
