package edu.uw.data.lecture3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * unidirectional , one-to-one fk .
 * one user has one passport , passport can belong to only one user
 * USERS table has a foreign key to the PASSPORT table.
 * USERS table also has a UNIQUE constraint on PASSPORT_ID
 * USERS --> PASSPORT
 */
@Entity
@Table
public class Passport implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "PASSPORT_NUMBER")
    private String passportNumber;

    @Column(name = "ISSUE_YEAR")
    private Integer issueYear;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Integer getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(Integer issueYear) {
        this.issueYear = issueYear;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", passportNumber='" + passportNumber + '\'' +
                ", issueYear=" + issueYear +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof edu.uw.data.lecture3.model.Passport)) return false;

        edu.uw.data.lecture3.model.Passport passport = (edu.uw.data.lecture3.model.Passport) o;

        return passportNumber.equals(passport.passportNumber);

    }

    @Override
    public int hashCode() {
        return passportNumber.hashCode();
    }
}
