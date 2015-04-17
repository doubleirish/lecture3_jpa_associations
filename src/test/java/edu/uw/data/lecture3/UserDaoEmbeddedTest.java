package edu.uw.data.lecture3;


import edu.uw.data.lecture3.dao.UserDao;
import edu.uw.data.lecture3.model.CreditCard;
import edu.uw.data.lecture3.model.User;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Embedded database is  always initialized cleasnly  as its stored in the target subdir which is cleared out on each run
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/userapp-spring.xml",
        "classpath:/datasource-embedded-init.xml"
        //  "classpath:/datasource-standalone-test.xml"
})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)

public class UserDaoEmbeddedTest extends AbstractTransactionalJUnit4SpringContextTests {

    static final Logger log = LoggerFactory.getLogger(UserDaoEmbeddedTest.class);

    @Resource
    private UserDao userDao;

    @Override
    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }


    @Test
    public void findUserByUsername() {

        User credmond = userDao.findByUsername("credmond");
        log.info("foundUser " + credmond);
        assertNotNull(credmond);
        assertEquals(1L, credmond.getId().longValue());
    }

    @Test
    public void createUser() {
        User newUser = new User.Builder()
                .userName("new")
                .firstName("first")
                .lastName("last")
                .activeSince(new Date())
                .phone("HOME", "123-555-1212")
                .phone("CELL", "425-555-9999")
                .build();

        User save = userDao.save(newUser);
        log.info("saved " + save);

        User foundUser = userDao.findByUsername("new");
        assertThat(foundUser.getFirstName(), is("first"));
        assertThat(foundUser.getPhoneNumbers().size(), is(2));
        log.info("foundUser " + foundUser);
    }

    @Test
    public void readUser() {
        User user = userDao.findById(1);
        log.info("foundUser " + user);
        assertNotNull(user);
        assertNotNull(user.getId());
        assertThat(user.getUserName(), is("credmond"));
    }


    @Test
    public void update_PrimitivesOnly() {

        int jsmithId = 2;
        User user = userDao.findById(jsmithId);
        log.info("before update " + user);

        user.setUserName("jsmith2");
        user.setFirstName("John2");
        user.setLastName("Smith2");
        user.setActiveSince(new Date());


        User updatedUser = userDao.findById(jsmithId);
        log.info("before update " + user);
        assertNotNull(updatedUser);
        assertEquals("John2", updatedUser.getFirstName());

    }


    @Test
    public void addCreditCardToExistingUser() {

        int userId = 3;
        User beforeUser = userDao.findById(userId);
        int countCardsBefore = beforeUser.getCreditCards().size();
        log.info("before update beforeUser " + beforeUser.getUserName() + " has " + countCardsBefore + " creditcard(s)");

        CreditCard visa = new CreditCard();
        visa.setCardNumber("1234567890123456");
        visa.setExpirationDate(new LocalDate().plusYears(1).toDate());

        //add credit card
        beforeUser.getCreditCards().add(visa);


        userDao.save(beforeUser);

        User afterUser = userDao.findById(userId);
        int countCardsAfter = afterUser.getCreditCards().size();
        log.info("before update user " + afterUser.getUserName() + " has " + countCardsAfter + " creditcard(s)");


        assertThat(countCardsAfter, is(countCardsBefore + 1));

    }


    @Test
    public void deleteTempUser() {


    }


    @Test
    public void findAll() {
        log.info("userDao " + userDao);
        List<User> users = userDao.findAll();
        assertNotNull(users);
        assertTrue(users.size() > 0);
        users.forEach(System.out::println);
    }


}
