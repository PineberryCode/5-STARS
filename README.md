# MINI-NETSERVICE

It is a web page about net services (Optical Fiber and classic Wi-Fi).

Create the file **application.yml** in this route:
```txt 
/src/main/resources/
```
Then paste this code in the file **application.yml**:

```YML
spring:
  mail:
    host: smtp.gmail.com
    username: Your Email
    password: Application password (GMAIL)
    port: 587
    properties:
      mail:
        smtp:
          starttls:
            enable: true
          auth: true
```
