package edu.uw.data.lecture3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by credmond on 03/03/15.
 */
@Entity
@Table(name = "PHONE")
public class Phone implements Comparable, Serializable {
    private static final long serialVersionUID = 2L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "LABEL")
    private String label;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    public Phone() {
    }

    public Phone(String label, String phoneNumber) {
        this.label = label;
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLabel() {
        return label;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public int compareTo(Object obj) {
        int compare = 0;
        Phone that = (Phone) obj;
        return this.phoneNumber.compareTo(that.phoneNumber);
    }

    @Override
    public String toString() {
        return "" + label + "='" + phoneNumber + "' ";
    }


    public static class Builder {
        private Phone phone;

        public Builder() {
            phone = new Phone();
        }

        public Builder builder() {
            return new Builder();
        }

        public Builder label(String label) {
            phone.label = label;
            return this;
        }

        public Builder number(String number) {
            phone.phoneNumber = number;
            return this;
        }

        public Phone build() {
            //validate ??;
            return phone;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof edu.uw.data.lecture3.model.Phone)) return false;

        edu.uw.data.lecture3.model.Phone phone = (edu.uw.data.lecture3.model.Phone) o;

        if (label != null ? !label.equals(phone.label) : phone.label != null) return false;
        return !(phoneNumber != null ? !phoneNumber.equals(phone.phoneNumber) : phone.phoneNumber != null);

    }

    @Override
    public int hashCode() {
        int result = label != null ? label.hashCode() : 0;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }
}
