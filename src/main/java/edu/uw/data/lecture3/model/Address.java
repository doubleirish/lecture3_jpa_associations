package edu.uw.data.lecture3.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Unidirectional Many to One (FK) Table user-address
 * many users can have the same address
 * USERS table has a foreign key reference to the ADDRESS table
 * USERS --> ADDRESS
 */
@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    Integer Id;

    @NotEmpty
    @Column
    private String street;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String zip;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

    public static class Builder {
        private Address address;

        public Builder() {
            address = new Address();
        }

        public Builder builder() {
            return new Builder();
        }


        public Builder street(String street) {
            address.setStreet(street);
            return this;
        }


        public Builder city(String city) {
            address.setCity(city);
            return this;
        }

        public Builder state(String state) {
            address.setState(state);
            return this;
        }

        public Builder zip(String zip) {
            address.setZip(zip);
            return this;
        }


        public Address build() {
            //validate ??;
            return address;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof edu.uw.data.lecture3.model.Address)) return false;

        edu.uw.data.lecture3.model.Address address = (edu.uw.data.lecture3.model.Address) o;

        if (!street.equals(address.street)) return false;
        if (!city.equals(address.city)) return false;
        if (!state.equals(address.state)) return false;
        return zip.equals(address.zip);

    }

    @Override
    public int hashCode() {
        int result = street.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + zip.hashCode();
        return result;
    }
}
