CREATE SCHEMA IF NOT EXISTS LIBRARY;

CREATE TABLE IF NOT EXISTS LIBRARY.PERSON
(
  ID INTEGER PRIMARY KEY auto_increment,
  FIRST_NAME NVARCHAR2,
  LAST_NAME NVARCHAR2,
  CONSTRAINT uq_person UNIQUE (FIRST_NAME, LAST_NAME)
);

CREATE TABLE IF NOT EXISTS LIBRARY.AUTHOR
(
  ID INTEGER PRIMARY KEY auto_increment,
  FIRST_NAME NVARCHAR2,
  LAST_NAME NVARCHAR2,
  CONSTRAINT uq_author UNIQUE (FIRST_NAME, LAST_NAME)
);

CREATE TABLE IF NOT EXISTS LIBRARY.BOOK
(
  ID INTEGER PRIMARY KEY auto_increment,
  AUTHOR_ID INTEGER REFERENCES LIBRARY.AUTHOR,
  TITLE NVARCHAR2
);

CREATE TABLE IF NOT EXISTS LIBRARY.LIBRARIAN
(
  ID INTEGER PRIMARY KEY auto_increment,
  USERNAME NVARCHAR2 NOT NULL UNIQUE,
  PASSWORD VARCHAR_IGNORECASE(100) NOT NULL,
  FIRST_NAME NVARCHAR2,
  LAST_NAME NVARCHAR2
);

CREATE TABLE IF NOT EXISTS LIBRARY.CHECKOUT
(
  ID INTEGER PRIMARY KEY auto_increment,
  PERSON_ID INTEGER NOT NULL REFERENCES LIBRARY.PERSON,
  BOOK_ID INTEGER NOT NULL REFERENCES LIBRARY.BOOK,
  LIBRARIAN_ID INTEGER NOT NULL REFERENCES LIBRARY.LIBRARIAN,
  CHECKOUT_TIME TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CHECKIN_TIME TIMESTAMP,
  USER NVARCHAR2
);

CREATE TABLE IF NOT EXISTS LIBRARY.CHECKOUT_HY
(
  ID INTEGER PRIMARY KEY auto_increment,
  PERSON_ID INTEGER NOT NULL REFERENCES LIBRARY.PERSON,
  BOOK_ID INTEGER NOT NULL REFERENCES LIBRARY.BOOK,
  LIBRARIAN_ID INTEGER NOT NULL REFERENCES LIBRARY.LIBRARIAN,
  CHECKOUT_TIME TIMESTAMP NOT NULL,
  CHECKIN_TIME TIMESTAMP,
  USER NVARCHAR2 NOT NULL DEFAULT CURRENT_USER,
  TIME TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  ACTION NVARCHAR2
);

CREATE TABLE IF NOT EXISTS PUBLIC.USERS
(
  username varchar_ignorecase(100) not null primary key,
  password varchar_ignorecase(100) not null,
  enabled boolean not null
);

CREATE TABLE IF NOT EXISTS PUBLIC.AUTHORITIES
(
  username varchar_ignorecase(50) not null,
  authority varchar_ignorecase(50) not null,
  constraint fk_authorities_users foreign key(username) references PUBLIC.USERS(username) ON DELETE CASCADE
);
