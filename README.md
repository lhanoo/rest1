rest1
=====

Demonstration of securing RESTful Spring web service using Spring Security.

# To run this project

Use maven command `mvn clean spring-boot:run`

# To test

You need `curl` tool (Windows version available at http://curl.haxx.se/download.html)

## Login with ROLE_USER using bob:bob123
    $ curl -i -X POST -d 'u=bob&p=bob123' http://localhost:8080/login
    Server: Apache-Coyote/1.1
    X-Content-Type-Options: nosniff
    X-XSS-Protection: 1; mode=block
    Cache-Control: no-cache, no-store, max-age=0, must-revalidate
    Pragma: no-cache
    Expires: 0
    X-Frame-Options: DENY
    Set-Cookie: JSESSIONID=BBF728A464BBF59683435D7920C95D50; Path=/; HttpOnly
    Accept-Charset: ...
    Content-Type: text/plain;charset=UTF-8
    Content-Length: 25
    Date: Tue, 13 Jan 2015 23:23:33 GMT
    
    Authentication successful

## Get list of all cats
    $ curl -i -H 'Cookie: JSESSIONID=BBF728A464BBF59683435D7920C95D50' http://localhost:8080/cats
    
Note the JSESSIONID cookie should correspond to that obtained from login