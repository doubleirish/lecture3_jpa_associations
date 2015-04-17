package edu.uw.data.lecture3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * bidirectional many to one . many users can have the same bank account e.g a joint account
 * A joint  bank account, many users can share the same account
 * USERS has a foreign key to BANK_ACCOUNT
 * USERS --> BANK_ACCOUNT
 */
@Entity
@Table(name = "BANK_ACCOUNT")
public class BankAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //
    @OneToMany(mappedBy = "bankAccount")  // pointing users's bankAccount field
    @Column(name = "id")    // inverse=true (i.e we're on the other side of the Foreign key), user.id
    private Set<User> users;

    @Column
    private BigDecimal balance;


    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                //  ", users=" + users +
                ", balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof edu.uw.data.lecture3.model.BankAccount)) return false;

        edu.uw.data.lecture3.model.BankAccount that = (edu.uw.data.lecture3.model.BankAccount) o;

        return accountNumber.equals(that.accountNumber);

    }

    @Override
    public int hashCode() {
        return accountNumber.hashCode();
    }
}
