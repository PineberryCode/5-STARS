# MINI-NETSERVICE

It is a web page about net services (Optical Fiber and classic Wi-Fi).

To that sending of E-mails, works shall create a file called **application** 'cause the Maven archetype can only read the word "reserved". It's preferable to make another file with the extension _.yml_ for more order.

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
