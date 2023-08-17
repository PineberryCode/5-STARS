# MINI-NETSERVICE

It is a web page about net services (Optical Fiber and classic Wi-Fi).

To that sending of E-mails, You shall create a configuration file called **application** because the Maven archetype only recognizes that "reserved" term. It's preferable to make another file with the extension _.yml_ this approach enhances the overall project structure.

Make sure to create the file on this route. Specifically **/resources**:

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
