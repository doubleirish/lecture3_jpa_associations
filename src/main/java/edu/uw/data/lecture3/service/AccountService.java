package edu.uw.data.lecture3.service;

import edu.uw.data.lecture3.model.CreditCard;
import edu.uw.data.lecture3.model.Phone;
import edu.uw.data.lecture3.model.User;

import java.math.BigDecimal;

/**
 * Created by credmond on 24/03/15.
 */
public interface AccountService {
    BigDecimal checkBalance(String username);

    BigDecimal transferFunds(String fromUsername, String toUsername, BigDecimal amount);


    User addCreditCardToUsername(String username, CreditCard card);

    User addPhoneToUsername(String username, Phone phone);

    User updateNameAndAddress(Integer userId, String lastName, String street);

    void deleteUser(Integer userId);

}
