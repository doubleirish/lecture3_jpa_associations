INSERT INTO ADDRESS (ID,   ZIP,      STATE,  CITY,        STREET )
values (1,   '98052',  'WA',   'Seattle',    '9999 Belview Ave');

INSERT INTO ADDRESS (ID,   ZIP,      STATE,  CITY,        STREET )
values (2,    '98034',  'WA',   'Kirkland',    '123 Main St');


INSERT INTO DEPARTMENT (ID,   NAME )
values (1,         'SALES');

INSERT INTO DEPARTMENT (ID,   NAME )
values (2,         'MARKETING');

INSERT INTO DEPARTMENT (ID,   NAME )
values (3,         'IT');

INSERT INTO PASSPORT (ID,   PASSPORT_NUMBER, ISSUE_YEAR )
              values (1,   'ZX81CPC464' ,    1999);


INSERT INTO BANK_ACCOUNT (ID,   ACCOUNT_NUMBER ,        BALANCE)
                  values (99,   '23490-2023-239823-23' ,5000.00);

INSERT INTO BANK_ACCOUNT (ID,   ACCOUNT_NUMBER ,        BALANCE)
values (88,   '890-43653-3453345-334' ,1000.00);


INSERT INTO SOUL (ID,   SOULCIAL_SECURITY_NUMBER )
values (666,   '123-45-67890' );

INSERT INTO USERS (USERNAME,   FIRSTNAME, LASTNAME,  ACTIVE_SINCE, ADDRESS_ID, DEPARTMENT_ID, PASSPORT_ID, BANK_ACCOUNT_ID ,SOUL_ID)
            values('credmond', 'Conor'  , 'Redmond', '2014-12-31',  1        ,  1 ,            1,             99,           666);

INSERT INTO USERS (USERNAME,   FIRSTNAME, LASTNAME,  ACTIVE_SINCE, ADDRESS_ID, DEPARTMENT_ID)
values('jsmith', 'John'  ,    'Smith',   '2014-02-28',  2 , 1 );


INSERT INTO USERS (USERNAME,   FIRSTNAME, LASTNAME,  ACTIVE_SINCE, DEPARTMENT_ID)
values('pdiddy', 'Puffy'  ,    'Combs',   '2014-07-04', 1);

INSERT INTO USERS (USERNAME,   FIRSTNAME, LASTNAME,  ACTIVE_SINCE, ADDRESS_ID, DEPARTMENT_ID, BANK_ACCOUNT_ID)
            values('aredmond', 'Ana'  , 'Redmond', '2011-12-31',    1        ,  2 ,            88);



INSERT INTO PROFILE (ID,   SITE_URL )
             values (1,   'www.uw.edu/credmond'  );
INSERT INTO PROFILE (ID,   SITE_URL )
             values (2,   'www.uw.edu/jsmith'  );


INSERT INTO CREDIT_CARD (  USER_ID  , CARD_NUMBER,       EXPIRATION_DATE ) values
  (   1,        '1234567890123456' , CURRENT_DATE);

INSERT INTO CREDIT_CARD (  USER_ID  , CARD_NUMBER,       EXPIRATION_DATE ) values
  (   1,        '8209390845202398674' , CURRENT_DATE);


INSERT INTO PHONE (USER_ID,   LABEL,      PHONE_NUMBER )
values (1,         'HOME',     '123-555-6789' );

INSERT INTO PHONE (USER_ID,   LABEL,      PHONE_NUMBER )
values (1,         'CELL',     '555-555-1212' );
