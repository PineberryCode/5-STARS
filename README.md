# MINI-NETSERVICE

It is a web page about net services (Optical Fiber and classic Wi-Fi).

Set the file **application.yml**; _username_ and _password_:

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
