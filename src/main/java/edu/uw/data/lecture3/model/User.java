package edu.uw.data.lecture3.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * User can have one Adress but many Phone Numbers
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "ACTIVE_SINCE")
    private Date activeSince;

    // unidirectional , USERS table has a foreign key reference to the ADDRESS table
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;


    // bidirectional , USERS table has a foreign key reference to the BANK_ACOUNT table
    @ManyToOne
    @JoinColumn(name = "BANK_ACCOUNT_ID")
    private BankAccount bankAccount;


    // unidirectional,USERS table has a foreign key (with unique constraint)to the PASSPORT table.
    @OneToOne //default join column of id
    private Passport passport;


    // bidirectional, USERS table has a foreign key SOUL_ID to the SOUL  table.
    @OneToOne
    @JoinColumn(name = "SOUL_ID")
    private Soul soul;

    //shared primary key, no FK constraints
    @OneToOne
    @PrimaryKeyJoinColumn
    private Profile profile;

    @ManyToOne
    private Department department;


    // unidirectional one-to many user-cards, CREDIT_CARD table has a FK to USERS
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID") // foreign key on CREDIT_CARD table to map back to USER table
    private Set<CreditCard> creditCards = new TreeSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Phone> phoneNumbers = new TreeSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Date getActiveSince() {
        return activeSince;
    }

    public void setActiveSince(Date activeSince) {
        this.activeSince = activeSince;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Phone> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<Phone> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void addPhoneNumber(Phone phone) {
        phone.setUser(this);
        this.phoneNumbers.add(phone);
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Set<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Soul getSoul() {
        return soul;
    }

    public void setSoul(Soul soul) {
        this.soul = soul;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", activeSince=" + activeSince +
                ", address=" + address +
                ", bankAccount=" + bankAccount +
                ", passport=" + passport +
                ", soul=" + soul +
                ", profile=" + profile +
                ", department=" + department +
                ", creditCards=" + creditCards +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }

    public static class Builder {
        private User user;

        public Builder() {
            user = new User();
        }

        public Builder builder() {
            return new Builder();
        }

        public Builder id(Integer id) {
            user.setId(id);
            return this;
        }

        public Builder userName(String userName) {
            user.setUserName(userName);
            return this;
        }

        public Builder firstName(String firstName) {
            user.setFirstName(firstName);
            return this;
        }

        public Builder lastName(String lastName) {
            user.setLastName(lastName);
            return this;
        }

        public Builder activeSince(Date activeSince) {
            user.setActiveSince(activeSince);
            return this;
        }

        public Builder address(Address address) {
            user.setAddress(address);
            return this;
        }

        public Builder phoneNumbers(Set<Phone> phoneNumbers) {
            user.setPhoneNumbers(phoneNumbers);
            return this;
        }

        public Builder phone(Phone phone) {
            user.getPhoneNumbers().add(phone);
            return this;
        }

        public Builder phone(String label, String phoneNum) {
            user.getPhoneNumbers().add(new Phone(label, phoneNum));
            return this;
        }

        public User build() {
            //validate ??;
            return user;
        }
    }
}
