# Timechamp - Témalab 2021 beszámoló

## Az alkalmazás programozói dokumentációja

### A program célja
Maga a program célja egy csapat és időpont organizációs rendszer megvalósítása Spring Boot backenddel, melyben csapatokat, csapattagokat és eseményeket lehet kezelni.

### A program használata
A webes alkalmazás használata során a felhasználónak lehetősége van regisztrálnia egy fiókot, tetszőleges felhasználónévvel és jelszóval. Regisztráció után természetesen megnyílik a bejelentkezés funkció is.

A program magába foglal organizációkat, melyeket a felhasználók hozhatnak létre, és létrehozásuk után adminisztrációs joggal rendelkeznek felette.

Az alkalmazás tartalmaz továbbá csapatokat és azok tagjait, melyek egy külön fül alatt megtekinthetőek. A felhasználók létrehozhatnak csapatot, és jelentkezhetnek is csapatokba. A csapat létrehozója elfogadhatja a csapatába jelentkező felhasználókat, továbbá már meglévőket is kirúghat belőle.

A csapat létrehozója admin joggal rendelkezik a csapaton belül, azonban más csapattagokat is felruházhat vele, továbbá csatlakozhat a csapatával egy szervezethez.

Egy csapat adminja(i) létrehozhatnak, törölhetnek csapatspecifikus eseményeket, melyre minden csapattag jelentkezni tud. Az esemény létrehozója testreszabhatja az eseményt egyedi leírás megadásával. Az eseményeknél megtekinthetőek, hogy kik a jelenlegi résztvevők. Az eseményekhez elvégzendő feladatok is kötődhetnek, amelynek vannak felelősei, illetve egy esemény helyhez kötött, amelyhez hozzá lehet rendelni Google Maps kódot, nevet, hosszúságot, illetve szélességet.
### További dokumentációk majd ide
## Mit tanultunk a félév során?
### Effective Java //MAX 1 OLDAL
### Clean code
### Spring MVC
Egy olyan requrest-driven MVC framework, amely a Szervlet API-ra épül és web alkalmazásokat készíthetünk velük. 

#### Általános jellemzői:
- Az objektumok felelősségeinek jó szétválasztása (MVC,validátorok, stb.)
- Rugalmasan konfigurálható
- Nincsenek előírt ősosztályok, interfészek
- Annotációk támogatása
- Testre szabható validáció
- Több megjelenítési technológia támogatása (JSP, Thymeleaf)
- Nincs UI komponens modellje

A Controller egy központti résztvevője a Spring MVC-nek, hiszen a különböző HTML kérések (pl.: `GET`, `POST`, `DELETE`, `PUT`) feldolgozását is ő végzi.

#### Konfigurációja
Spring Boot nélkül XML és/vagy JavaConfigra lenne szükség a SpringMVC, és a Thymeleaf bekonfigurálásához, de Spring Boot esetén csupán két függőséget kell hozzáadni a `pom.xml`-hez:
```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

Az alkalmazás belépési pontja pedig a `@SpringBootApplication` annotációval ellátot osztály lesz. A Controler osztályainkat a `root` csomagba, vagy valamely alcsomagjába kell helyeznünk. A Thymeleaf-es `.html` fájlokat az `src\main\resources\templates` alá kell helyeznünk.

### Spring Boot
A Spring Boot egy keretrendszer, aminek segítségével könnyen és gyorsan írhatunk szerver oldali Java alkalmazásokat. A Spring-re épül, ami egy összetett, sok modulból álló framework. A Spring Boot pedig már a Spring által kínált eszközökből összeállított “váz”, ami egyszerűen bővíthető, és sok technikai részletet elfed a kényelmünk érdekében. 

#### Webalkalmazás futtatása
Ha a `pom.xml`-ünkben megtalálható a `spring-boot-starter-web`, akkor egy beágyazott konténert indíthatunk, default-ból Tomcat-et, így nem szükséges külön webkonténer, fejleszés során kimarad a deploy. Alap esetben a `8080`-as porton, a `http://localhost:8080/`-en keresztül.

Készíthetünk futtatható `.jar` fájlt is, ha a `pom.xml`-ben a packaging-ként jart állítunk be és a `spring-boot` plugin szerepel a pom-ban, amely függőségeket is belecsomagolja a jar-ba és a `spring boot loader`-t is, ami képes betölteni ezeket a függőségeket. Az `mvn package` parancs kiadásával már kész is a futtatható `jar` a `target` mappában.

Fejlesztés során a következőképpen tudjuk futtatni a Spring Boot alkalmazásunkat:
- `mvn spring-boot:run`, IDE-ből vagy parancssorból
- IDE+Spring Tools Suite esetén `Run as/Debug as Spring Boot App` (ez gyorsabb a `spring:boot:run`-nál, mert nem teljes build, csak a futtatás, tehát kimaradnak a tesztek futtatása és a fordítás, de ez utóbbit az IDE úgyis megcsinálja
- Ha ezeket `debug` módban végezzük, a metódustörzs-módosítások automatikusan életbe lépnek, de egyéb kódmódosítások után restart szükséges. HTML, egyéb statikus fájlok módosításai automatikusan frissülnek, ha a static vagy templates folderben vannak (+ Thymeleaf esetén cache kikapcsolva)
- További lehetőségek is léteznek (pl.: `spring-boot-devtools`,  `spring-loaded`, JRebel plugin).

#### A Controller osztály
URL leképezésért felelős: tetszőleges számú handler metódusa lehet, amelyek más-más URL-t kezelnek. Maga a controller osztály is kaphat `@RequestMapping` annotációt, ilyenkor ehhez relatívan értelmeződnek a handler metódusokon lévő URL minták.

#### HttpMessageConverter
HTTP kérés törzsét lehet leképezni vele objektummá, a `@RequestBody` `@ResponseBody` annotációk (bemenő paraméterek) esetében, így ez nagy jelentőséggel bír REST stílusű webalkalmazások esetében.

### Thymeleaf
### REST
### Maven

#### Mi a Maven?
Egy parancssori build automatizáló eszköz, amely igen elterjedt, számos best practice-t integrál, külső pluginokat is be lehet importálni, például Lombok vagy Mapstruct.

#### A Maven főbb előnyei
- Erősen testreszabható
- Pluginezhető
- Képes függőségek letöltésére, akár tranzitívan is
- Különböző fejlesztői környezetekkel is szerkeszthető ugyanaz a projekt
- Build szerverek (pl.: Jenkins) is tudnak buildelni
- 
#### Hogyan kell használni a Mavent?
A konfig fájl a `pom.xml`, amely a projekt gyökerében található. Ennek főbb, a projektben is használt elemei:
- `<groupId>`, `<artifactId>`: azonosítják a projektet
- `<version>`: verzió
- `<dependencies>`: függőségek
- `<build>`: a build testreszabása, jellemzően pluginekkel
- `<properties>`: konfigolható placeholderek

Az open source projektek egy része Mavent használ, és ezek lebuildelt verziója felkerül a Maven publikus repositoryba. A projektünkben függőségeket deklarálhatunk a következő módon:
```
<dependency>
  <groupId>org.hibernate</groupId>
  <artifactId>hibernate-entitymanager</artifactId>
  <version>4.3.10.Final</version>
</dependency>
```
A függőségeket a publikus repositorybl próbálja meg letölteni a Maven, és mivel ezek a függőségek is rendelkeznek `pom.xml`-el, ezért tranzitívan telepítődik a többi függőség is.
  
Egyéb repository-kat is deklarálhatunk (cégen belüli, saját repokban publikált projektek): 
```
<repositories>
  <repository>
    <id>my-internal-site</id>
    <url>http://myserver/repo</url>
  </repository>
</repositories>
```

#### Build életciklus
Default életciklus:
- `validate`: projekt validálása
- `compile`: `src/main/java` alatti java fájlok fordítása
- `test`: unit tesztek lefuttatása (hiba esetén leáll)
- `package`: a `main`-ből fordított class fájlok és a `src/main/resources` (`war` esetén `src/main/webapp` is) alatti fájlok csomagolása `.jar`/`war` formátumba
- `integration-test`: integrációs tesztek előkészítése (pl. telepítés teszt szerverre)
- `verify`: minőségi ellenőrzés
- `install`: kész termék másolása a local repositoryba
- `deploy`: kész termék feltöltése egy távoli repositoryba

Minden kimeneti fájl, jar, war a projekt target könyvtárba kerül. Az `mvn clean` paranccsal viszont törölhetjük ezt, illetve a verziókezelőben is ignorálhatjuk.
  
#### Maven modulok
Egy Maven projektnek lehet szülője vagy gyermeke egy másiknak:
- `<modules>` tag a szülőben
- `<parent>` tag a gyerekben

Ha egy szülőt buildelünk, akkor a gyerek buildelése is végbemegy, ugyan azzal a goal-lal. Ha a gyerekek között van függőség akkor ez a buildelési folyamat tranzitív.
Miért jó ez? Hát azért, mert a szülő megadhatja a közösen használt dependency-k verzióit (természetes magukat a modulokat ugyanúgy bele kell rakni a gyermekek konfig fájlába, de elég verzió nélkül).
  
#### Maven profilok
Gyakori igény lehet cégeknél például, hogy a fejlesztői, teszt vagy éles környezetre másképp szeretnénk buildelni. Erre vannak a profilok.

### JPA
### Lombok
### Mapstruct
