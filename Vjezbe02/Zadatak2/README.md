# Zadatak 2

Main klasa u ulozi `HttpServlet`, registrirana kroz *web.xml*

*pom.xml* je definiran da se pakira kao war sa `<packaging>war</packaging>`.
 
Sadrži osnovne definicije verzije Java SDK za kompajliranje i encoding datoteka:
 
```xml
    <properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
    </properties>
```

Što je preporučljivo (ali ne nužno) za svaki *pom.xml*

Ostali dependency-i su za jetty servlet tako da bi server mogao ispisati željeni tekst na ekran
