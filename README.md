# homeboy

Add a application yml in src/main/resources with content above for local tests

```
---
spring:
  profiles: development
  application:
    name: homeboy
  datasource:
    url: jdbc:mysql://mysql/homeboy
    username: root
    password: root
    driverClassName:
    maxActive: 10
    maxIdle: 5
    minIdle: 2
    initialSize: 5
    removeAbandoned: true
    tomcat:
      max-active: 10
      max-wait: 10000
      test-on-borrow: true
      test-while-idle: true
      validation-query: select 1;
  jpa:
    hibernate.ddl-auto: update
 ```
