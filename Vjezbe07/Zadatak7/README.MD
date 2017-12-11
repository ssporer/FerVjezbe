# Spring Security

Aplikacija je bazirana na Thymeleaf zadatku06 na vježbama 6.

* Datasource je vraćen na tcp konekciju
* Implementiran je Spring Security
* Dodana je schema za defaultne tablice od spring security-a
* Dodani su secure i public ekrani u Thymeleafu

Security je definiran u `SecurityConfig` konfiguraciji sa autentikacijom preko JDBC konekcije i defaultnom schemom.

Autorizacija je implementirana kroz sva tri sloja:

* Unutar Thymelafa, unutar `library/index.html` samo administrator može vidjeti i brisati iznajmljene knjige
* Unutar same konfiguracije, preko antMatcher-a, resource autorizacija
* Unutar `CheckoutService`, preko bean autorizacije anotacijom `@Secured` 
