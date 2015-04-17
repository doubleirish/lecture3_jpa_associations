package edu.uw.data.lecture3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * unidirectional one-to many user-cards
 * User has many credit cards
 */

@Entity
@Table(name = "CREDIT_CARD")
public class CreditCard implements Serializable {
    private static final long serialVersionUID = 1L;


    //  @SequenceGenerator(name="credit_seq_gen", sequenceName="credit_card_id_seq")
//  @GeneratedValue(generator="credit_seq_gen")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column(name = "CARD_NUMBER")
    private String cardNumber;



    @Temporal(value = TemporalType.DATE)

    @Column(name = "EXPIRATION_DATE")
    private Date expirationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof edu.uw.data.lecture3.model.CreditCard)) return false;

        edu.uw.data.lecture3.model.CreditCard that = (edu.uw.data.lecture3.model.CreditCard) o;

        return cardNumber.equals(that.cardNumber);

    }

    @Override
    public int hashCode() {
        return cardNumber.hashCode();
    }
}