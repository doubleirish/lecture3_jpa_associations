/* tables that are have a ref to USERS (children of users)*/
DROP TABLE PHONE ;
DROP TABLE CREDIT_CARD ;

DROP TABLE USERS ;

/* tables that users has a ref to (parent of users)*/
DROP TABLE PROFILE ;
DROP TABLE ADDRESS ;
DROP TABLE DEPARTMENT ;
DROP TABLE PASSPORT ;
DROP TABLE BANK_ACCOUNT ;
DROP TABLE SOUL ;
DROP SEQUENCE credit_card_id_seq RESTRICT ;
