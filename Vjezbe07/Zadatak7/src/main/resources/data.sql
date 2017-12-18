MERGE INTO LIBRARY.AUTHOR (FIRST_NAME, LAST_NAME) KEY (FIRST_NAME, LAST_NAME) VALUES ('Franz', 'Kafka');
MERGE INTO LIBRARY.BOOK (ID, TITLE, AUTHOR_ID) KEY (ID) VALUES (SELECT TOP(1) ID FROM LIBRARY.BOOK WHERE TITLE = 'The Metamorphosis', 'The Metamorphosis', SELECT ID FROM LIBRARY.AUTHOR WHERE FIRST_NAME = 'Franz' AND LAST_NAME = 'Kafka');
MERGE INTO LIBRARY.LIBRARIAN (USERNAME, FIRST_NAME, LAST_NAME) KEY (USERNAME) VALUES ('rgiles', 'Rupert', 'Giles');
MERGE INTO LIBRARY.LIBRARIAN (USERNAME, FIRST_NAME, LAST_NAME) KEY (USERNAME) VALUES ('admin', 'admin', 'admin');
MERGE INTO LIBRARY.LIBRARIAN (USERNAME, FIRST_NAME, LAST_NAME) KEY (USERNAME) VALUES ('user', 'user', 'user');
MERGE INTO LIBRARY.PERSON (FIRST_NAME, LAST_NAME) KEY (FIRST_NAME, LAST_NAME) VALUES ('John', 'Doe');
MERGE INTO PUBLIC.USERS (USERNAME, PASSWORD, ENABLED) KEY (USERNAME) VALUES ('rgiles', '$2a$10$p6hHyIDwqhRC4dj3rmpZ0ujI5P/FyWFepUCAw7OAGnhwMCPs3cDmK', TRUE); -- password: pass
MERGE INTO PUBLIC.USERS (USERNAME, PASSWORD, ENABLED) KEY (USERNAME) VALUES ('admin', '$2a$10$tAS5EfWEgMpTQbIw7y.dqefTtBefA3uyl019h7wIJWCGFZj0yJZYq', TRUE); -- password: pass
MERGE INTO PUBLIC.USERS (USERNAME, PASSWORD, ENABLED) KEY (USERNAME) VALUES ('user', '$2a$10$tAS5EfWEgMpTQbIw7y.dqefTtBefA3uyl019h7wIJWCGFZj0yJZYq', TRUE); -- password: pass
MERGE INTO PUBLIC.AUTHORITIES (USERNAME, AUTHORITY) KEY (USERNAME, AUTHORITY) VALUES ('rgiles', 'ROLE_LIBRARIAN');
MERGE INTO PUBLIC.AUTHORITIES (USERNAME, AUTHORITY) KEY (USERNAME, AUTHORITY) VALUES ('admin', 'ROLE_ADMIN');
MERGE INTO PUBLIC.AUTHORITIES (USERNAME, AUTHORITY) KEY (USERNAME, AUTHORITY) VALUES ('user', 'ROLE_USER');