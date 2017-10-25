# Zadatak 1
Main klasa koja ispisuje `Vjezba 1` u konzolu i POM koji pakira projekt u executable *.jar*

Obratiti pažnju na `maven-jar-plugin` koji dodaje *MANIFEST.MF* u jar sa informacijom o main klasi bez koje Java ne bi znala za entry jar-a.

```xml
<plugin>
    <artifactId>maven-jar-plugin</artifactId>
    <configuration>
        <archive>
            <manifest>
                <mainClass>Main</mainClass>
            </manifest>
        </archive>
    </configuration>
</plugin>
```

Isto se moglo postići ručnim stvaranjem *MANIFEST.MF* datoteke, ali prednost se uvijek daje generiranju.
