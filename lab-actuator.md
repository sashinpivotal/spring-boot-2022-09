## Extra Actuator lab

You can start with any Web application of your choice.
In the instruction below, **demo-spring-boot-actuator** is used.

### Get build information

- Add the **executions** element to the **spring-boot-maven-plugin** plugin as following: (This is to get some build information)

```
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <executions>
                    <execution>
                        <goals>
                            <goal>build-info</goal>
                        </goals>
                        <configuration>
                            <additionalProperties>
                                <encoding.source>UTF-8</encoding.source>
                                <encoding.reporting>UTF-8</encoding.reporting>
                                <java.source>${maven.compiler.source}</java.source>
                                <java.target>${maven.compiler.target}</java.target>
                            </additionalProperties>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```

- Execute "mvn package" and make sure "target/classes/META-INF/build-info.properties" file gets created
- Rerun the application
- Access [http://localhost:8080/actuator/info](http://localhost:8080/actuator/info)


### Change logging level

- Add **HelloController.java**

```
package demo.springbootactuator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${name:dummyName}")
    private String name;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/hello")
    public String hello() {
        logger.info("--->INFO message");
        logger.debug("--->DEBUG message");
        return "hello " + name;
    }
}
```

- Rerun the application
- Access the current logging level by sending HTTP GET request

```
curl -H"Accept: application/json" localhost:8080/actuator/loggers/demo.springbootactuator
```

- Access [http://localhost:8080/hello](http://localhost:8080/hello) and observe only INFO message is displayed

- Change the logging level of **demo.springbootactuator** package by sending HTTP post  (You can use Postman if you don't have curl)

```
curl -i -XPOST -H"Content-Type: application/json" localhost:8080/actuator/loggers/demo.springbootactuator -d'{"configuredLevel": "DEBUG"}'
```

- Access [http://localhost:8080/hello](http://localhost:8080/hello) and observe that both INFO and DEBUG messages are displayed
- Change the logging level back to "INFO" and access the above URL again

### Display System Health information

- Add the following to the "application.properties"

```
management.endpoint.health.group.system.include=diskSpace,db,mongo
management.endpoint.health.group.system.show-details=always
management.endpoint.health.group.web.include=ping
management.endpoint.health.group.application.include=customHealthCheck
management.endpoint.health.group.application.show-details=always
```

- Add the following dependencies to the **pom.xml**

```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-mongodb</artifactId>
        </dependency>
```

- Refresh Maven in IntelliJ
- Rerun the application
- Access [http://localhost:8080/actuator/health/system](http://localhost:8080/health/system)
- Start and stop the MongoDB server and check the health status

- For your own exercise, see if you can add things to the project to see the health status of Cassandra 

### Display Custom Health information

- Add custom HealthIndicator bean

```
package demo.springbootactuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthCheck implements HealthIndicator {

    private int testInteger = 0;

    @Override
    public Health health() {

        if ( testInteger++ % 2 == 0) {
            return Health.up()
                    .withDetail("testInteger", testInteger)
                    .build();
        } else {
            return Health.down()
                    .withDetail("testInteger", testInteger)
                    .build();
        }
    }
}
```

- Re-run the application
- Access [http://localhost:8080/actuator/health/application](http://localhost:8080/health/application)

- For your own exercise, add another custom health indicator to check if the **name** property displays your name or not.  If it does, display "UP", otherwise display "DOWN"

