# Thymeleaf

Aplikacija je izrađena na bazi podataka iz zadatka 5.

Umjesto Liquibase-a, koristi se automatska Spring Boot database inicijalizacija preko datoteka `schema.sql` i `data.sql`.

Komunikacija sa bazom nalazi se u `domain` paketu i implementirana je preko Spring JPA / Hibernate implementorom.

Web sučelje je izrađeno u HTML-u sa Thymeleaf MVC frameworkom.

Checkout se validira preko JSR303 anotacijama u DTO-u i prikazuje na ekranu u slučaju field errora
