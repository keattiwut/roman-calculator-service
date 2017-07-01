# roman-calculator-service


Scope:
* Read input file
* Can calculate Roman number
* Provided result to file

Prerequisite:

 * Java version 1.8
 * Maven version 3+

Technology Stack

 * Spring boot 1.5.4
 * Apache Common IO 1.3.2
 * Lombok

Build command:

```shell
mvn clean install
```

How to run

* Config input and output path in application-default.yml (on project or jar directory)

```java
application:
  file:
    input: ./input/input.txt
    output: ./output/output.txt
```

* Just run application by use command below

```shell
java -jar target/roman-calculator-service-0.0.1-SNAPSHOT.jar
```

* Check result on output path


