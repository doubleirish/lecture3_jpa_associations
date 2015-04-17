package edu.uw.data.lecture3.service;

import edu.uw.data.lecture3.dao.UserDao;
import edu.uw.data.lecture3.model.BankAccount;
import edu.uw.data.lecture3.model.CreditCard;
import edu.uw.data.lecture3.model.Phone;
import edu.uw.data.lecture3.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Created by credmond on 24/03/15.
 */

@Transactional
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource(name = "userDao")
    UserDao userDao;


    @Override
    public BigDecimal checkBalance(String username) {
        BigDecimal balance = BigDecimal.ZERO;
        User user = userDao.findByUsername(username);
        BankAccount bankAccount = user.getBankAccount();
        if (bankAccount != null) {
            balance = bankAccount.getBalance();
        }
        log.info("checkBalance: " + user);
        return balance;
    }

    @Override
    public BigDecimal transferFunds(String fromUsername,
                                    String toUser,
                                    BigDecimal amount) {
        BigDecimal fundsTransferred = BigDecimal.ZERO;

        User fromUser = userDao.findByUsername(fromUsername);
        log.info("fromUser: " + fromUser);

        return fundsTransferred;
    }

    public User addCreditCardToUsername(String username, CreditCard card) {

        User user = userDao.findByUsername(username);
        int countCardsBefore = user.getCreditCards().size();
        log.info("before update user " + user.getUserName() + " has " + countCardsBefore + " creditcard(s)");


        //add credit card
        user.getCreditCards().add(card);

        userDao.save(user);
        log.info("after update user " + user.getUserName() + " has " + user.getCreditCards().size() + " creditcard(s)");


        return user;
    }

    public User updateNameAndAddress(Integer userId,
                                     String lastName,
                                     String street
    ) {

        User user = userDao.findById(userId);
        user.getAddress().setStreet(street);
        user.setLastName(lastName);
        userDao.save(user);


        return user;
    }

    public User addPhoneToUsername(String username, Phone phone) {

        User user = userDao.findByUsername(username);
        int phonesBefore = user.getPhoneNumbers().size();
        log.info("before update user " + user.getUserName() + " has " + phonesBefore + " phones(s)");


        // set both sides of the relationships manually
        // phone.setUser(user);
        // user.getPhoneNumbers().add(phone);
        // or use convenience add() function
        user.addPhoneNumber(phone); // bidirectional set in convenience function
        userDao.save(user);

        return user;
    }

    public void deleteUser(Integer userId) {
        userDao.deleteUserById(userId);
    }
}
