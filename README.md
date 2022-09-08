# Spring Boot Training

This file will be updated on a daily basis and will include any information that need to be communicated such as following:

- Daily topics to cover
- External resources that might be relevant
- Daily quiz on the topics covered during the previous day

## Logistics

### Introduction

- Instructor (Sang Shin) introduction
  - You can contact me at any time (before and after class included) via email
  - Email: <sangshinpassion@gmail.com>
  
- Individual ~30 minutes tutoring session is available upon request (during 1 hour period before the class)
  - [Individual tutoring signing sheet](https://docs.google.com/document/d/1ZC7L3Zd1LXeG40vW3fA0k4TRCLETNHrWI13BPLt2z74/edit)
  
- Course topics
  - Core topics (slide 2 and 3  of Spring_Boot_Slides.pdf)
  - Auxiliary topics (slide 4 and 5 of Spring_Boot_Slides.pdf)

- Student introduction
  - Your Java experience
  - Your Spring/Spring-Boot experience (if you have anay)
  - Your goals in taking this class
  - Any thoughts/suggestions on course topics

### Course material and Tools needed

- Course material is available from [here](https://tinyurl.com/mwvab64s)
- IDE of your choice (IntelliJ is recommended)
- JDK 14+ is recommended

### Daily schedule 
  
- 9:00AM - 1:00PM ET (New York time)
- 10 minutes break every hour (10:00AM, 11:00AM, 12:00AM ET)
- [Microsoft Teams Link](https://teams.microsoft.com/l/meetup-join/19%3ameeting_N2RhMmJhNjEtODE4Mi00N2IzLWJhNGYtYTZlNTljZTkzMTQx%40thread.v2/0?context=%7b%22Tid%22%3a%2292e84ceb-fbfd-47ab-be52-080c6b87953f%22%2c%22Oid%22%3a%22aaf6d74b-873f-4c59-a645-7d3cd2a2bee9%22%7d)
- [Daily attendance sign-up](https://netorgft4394772-my.sharepoint.com/:x:/g/personal/cc_en-lighten_io/EQmgmw5zAvFKn2qeteGkZHQB9Mzc-3d4Ad6RFYS3VjL0SA?e=5goLIW)


## Non-core topics that might or might not be covered depending on time

- NoSQL
- TDD
- Spring Boot deployment to the cloud
- Kafka
- Spring distributed transaction

## Day 1

### Topics/Labs 

- Introduction to Spring Boot 
  - slides: pages of 8-43 of Spring_Boot_Slides.pdf
  - lab: page 1-2 of spring_boot_exercise_instructions.pdf
  
- Spring Boot Development
  - slides: pages of 44-65 of Spring_Boot_Slides.pdf
  - lab: page 3-4 of spring_boot_exercise_instructions.pdf

### DI Demo

- The demo code is available under **demo-di3** project in the repo

### Spring tutorial resources

- [Spring Boot tutorial from Baeldung](https://www.baeldung.com/spring-boot)
- [Spring guides](https://spring.io/guides)

### IntelliJ shortcut keys

- Keyboard shortcut keys for IntelliJ (Mac)

```
- CMD+N (Context-sensitive Generate)
- ALT+Return (Quick fix)
- CMD+SHIFT+Return (Complete current statement)
- CMD+ALT+V (extract return value into a local variable)
- CTRL+SHIFT+R (run the app/test)
- CTRL+R(rerun the app/test)
- CMD+SHIFT+F12 (maximize/minimize editor window)
- CMD+SHIFT+' (Maximize/minimize tool window)
- CMD+SHIFT+T (go to target/test code)
- CMD+Left (navigate back)
- CMD+Right (navigate forward)
- CMD+O (find class)
- CMD+SHIFT+O (find file)
- Double SHIFT (global search)
- F2, SHIFT+F2 (Go to next/previous error)
```

- Keyboard shortcut keys for IntelliJ (Windows)

```
I could not locate Windows version :-) If you can share what you found, that will be great.
```

- For complete IntelliJ shortcut keys, please see [here](https://www.jetbrains.com/help/idea/mastering-keyboard-shortcuts.html) 

## Day 2

### Quiz on Day 1 topics

- What is dependency injection?  Why dependency injection?
- What is the Spring boot starter to make your app a Web application?
- The **@SpringBootApplication** is a composite annotation.
  What is that made of?
- What is the difference between **mvn** and **mvnw**?

### Topics/Labs of Day 2

- Beans and Configuration (Just presentation only)
  - slides: pages of 66-99 of Spring_Boot_Slides.pdf
  - lab: page 5-8 of spring_boot_exercise_instructions.pdf

### Misc. questions

1. Is there a way to intercept bean creation process and inspect it?

You can implement your own BeanPostProcessor bean, which gets called after each bean gets created, as following:

```
   @Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("---> before " + bean.getClass());
        return bean;
    }

    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("---> after");
        return bean;
    }
   }
```

1. What are the pros and cons of the two schemes of defining Spring Beans?
   
- Using @Configuration and @Bean methods: Pros
  - Single logical location for Spring bean configuration, provides easier maintenance of bean configuration
  - You can define beans from 3rd party library classes you do not have source code
  - You can customize Bean properties inside the @Bean method

- Using @Configuration and @Bean methods: Cons
  - Extra coding 

- Using component-scanning annotated classes: Pros
  - Simple to use 
  - Existence of stereo types: @Controller, @Service, @Repository

- Using component-scanning annotated classes: Cons
  - Could pose maintenance problem for large apps
  - Cannot be used in 3rd party library classes without source code
  - Violation of simple responsibility principle

- Recommendation
  - Use "component-scanning annotated classes" scheme for use cases where the usage of stereo types make sense
  - Use "@Configuration and @Bean methods" for the rest of the app
  
## Day 3

### Quiz on Day 2 topics

- What are the two schemes of defining Spring Beans?
- What is @Autowired annotation for?
- What is the @Configuration annotation for?
- How do you specify the dependency relationship between bean definitions in the configuration class?

  
### Topics/Labs of Day 3

- Beans and Configuration (We will do the lab)
  - slides: pages of 66-99 of Spring_Boot_Slides.pdf
  - lab: page 5-8 of spring_boot_exercise_instructions.pdf

- Additional Techniques (profile, actuator)
  - slides: pages of 107-136 of Spring_Boot_Slides.pdf
  - lab: page 9-10 of spring_boot_exercise_instructions.pdf
