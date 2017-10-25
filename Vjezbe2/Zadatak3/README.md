#Zadatak 3
Multimodularan projekt gdje je *Zadatak3* parent a *Zadatak3Child1* i *Zadatak3Child2* childovi projekta

To je definirano u parent *pom.xml* sa
```xml
<modules>
    <module>Zadatak3child1</module>
    <module>Zadatak3child2</module>
</modules>
```

dok child moduli imaju definiciju parenta preko njegovog jednoznačnog ID-a:
```xml
<parent>
    <artifactId>Zadatak3</artifactId>
    <groupId>hr.fer.java.vjezbe</groupId>
    <version>1.0-SNAPSHOT</version>
</parent>
```

Dependency management je po konvenciji definiran u parent *pom.xml*:
```xml
<dependencyManagement>
    <dependencies>
        ...
    </dependencies>
</dependencyManagement>
```

Korisno je definirati child element u dependency management, da se njegova verzija ne bi provlačila kroz ostale childove, iako nije nužno:
```xml
<dependency>
    <groupId>hr.fer.java.vjezbe</groupId>
    <artifactId>Zadatak3Child1</artifactId>
    <version>${project.version}</version>
</dependency>
```

Dependency se onda ubacuje u ostale child module **bez verzije**
```xml
<dependencies>
    <dependency>
        <groupId>hr.fer.java.vjezbe</groupId>
        <artifactId>Zadatak3Child1</artifactId>
    </dependency>
    ...
</dependencies>
```

Projekt se deploy-a sa Vjezba3Child2 projektom na tomcat i prikazuje poruku iz *Child2Main* i *Child1Main* u rootu na adresi [http://localhost:8080](http://localhost:8080)

