--liquibase formatted sql

--changeset id:1.2.1 author:zelbar
INSERT INTO LIBRARY.PERSON(ID, FIRST_NAME, LAST_NAME)
VALUES (10, 'Ana', 'Milovana');

--changeset id:1.2.2 author:zelbar
INSERT INTO LIBRARY.AUTHOR(ID, FIRST_NAME, LAST_NAME)
VALUES (10, 'Ivana', 'Brlic-Mazuranic');

--changeset id:1.2.3 author:zelbar
INSERT INTO LIBRARY.LIBRARIAN(ID, FIRST_NAME, LAST_NAME)
VALUES (10, 'Vesela', 'Lesina Plese');

--changeset id:1.2.4 author:zelbar
INSERT INTO LIBRARY.BOOK(ID, AUTHOR_ID, TITLE)
VALUES (10, 10, 'Bajke');

--changeset id:1.2.5 author:zelbar
INSERT INTO LIBRARY.CHECKOUT(ID, PERSON_ID, BOOK_ID, LIBRARIAN_ID, CHECKOUT_TIME, CHECKIN_TIME)
VALUES (10, 10, 10, 10, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());