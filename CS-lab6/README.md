# Single Sign On
> This is laboratory number 6 from Security, I implemented it using Java, Spring Boot and OAuth2.
>For logging with Facebook, Google and Github.
## Table of contents

* [Technologies](#technologies)
* [How to use](#how-to-use)
* [Code examples](#code-examples)
* [Features](#features)
* [Status](#status)

## Technologies
Java 11 
Spring Boot
Maven
OAuth2.0

## How to use
1. Import project with pom.xml
2. Change client secret to yours
3. Run SSOApplication

## Code Examples
Method of how you can add authentication from for example Github:
```java
private ClientRegistration gitHubClientRegistration(){
    return CommonOAuth2Provider.GITHUB.getBuilder("github")
            .clientId("<Pass here client id>")
            .clientSecret("Pass here client secret")
            .build();
    }
```
Controller:
```java
@RestController
public class MainController {

    @GetMapping("/")
    public String main(Authentication authentication){
        String authenticationData = authentication.toString();

        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html>");
        htmlBuilder.append("<head><title>Welcome</title></head>");
        htmlBuilder.append("<body><h1>Welcome!</h1><p>").append(authenticationData).append("</p></body>");
        htmlBuilder.append("</html>");
        String html = htmlBuilder.toString();

        return html;
    }
}
```

## FEATURES
• Offer user authentication via SSO using at least 3 identity providers (e.g. Facebook,
  Gmail, Twitter etc.)  
• Configure SSO integration to get as much as possible data about the end-user  
• Output all data which was provided by the identity providers (e.g. user’s name, age,
  gender, email etc.)  

## Status
Project is: _finished_
