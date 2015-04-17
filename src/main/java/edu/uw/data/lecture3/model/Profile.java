package edu.uw.data.lecture3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * unidirectional , one-to-one shared primary key  .
 * one user has one profile , profile can belong to only one user
 * USERS table and PROFILE table do not necessarily have any FK constraints.
 * <p/>
 * USERS(123) ..... PASSPORT(123)
 */
@Entity
@Table(name = "PROFILE")
public class Profile implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "SITE_URL")
    private String siteUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", siteUrl='" + siteUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof edu.uw.data.lecture3.model.Profile)) return false;

        edu.uw.data.lecture3.model.Profile profile = (edu.uw.data.lecture3.model.Profile) o;

        return siteUrl.equals(profile.siteUrl);

    }

    @Override
    public int hashCode() {
        return siteUrl.hashCode();
    }
}
