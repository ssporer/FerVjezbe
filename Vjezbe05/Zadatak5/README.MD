# Baze podataka

Spring boot aplikacija sa kombinacijom liquibase/JPA/MyBatis alatima za baratanje integriranom H2 bazom podataka.

Sadrži definiciju baze podataka za knjižnicu unutar liquibase skripti na standardnom mjestu `resources/db/changelog...` kao SQL i kao XML primjeri.

Za spajanje na bazu ima dvostruku implementaciju istog interface-a, jedna preko JPA i jedna preko Mybatis kao primjeri.

Rezultati se prikazuju preko controllera na url `/books` i `/book/<naziv knjige>`
