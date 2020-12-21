package com.ssolab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

/**
 * @author Beatrice V.
 * @created 17.10.2020 - 16:35
 * @project SSOlab
 */

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.oauth2Login();
        http.authorizeRequests()
                .anyRequest().authenticated();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository(){
        return new InMemoryClientRegistrationRepository(gitHubClientRegistration(), facebookClientRegistration(), googleClientRegistration());
    }

    private ClientRegistration gitHubClientRegistration(){
        return CommonOAuth2Provider.GITHUB.getBuilder("github")
                .clientId("schedulemap-258105")
                .clientSecret("03997f78cb127f1fccc51fe76376df916d5b7ac4")
                .build();
    }

    private ClientRegistration facebookClientRegistration(){
        return CommonOAuth2Provider.FACEBOOK.getBuilder("facebook")
                .clientId("633127737373819")
                .clientSecret("d14e2c5a5c0d41059a14a9950c0b7d69")
                .build();
    }
    private ClientRegistration googleClientRegistration(){
        return CommonOAuth2Provider.GOOGLE.getBuilder("google")
                .clientId("814855232299-imrs43jbpmj4ei3p94rtq8i2vi2gl1lq.apps.googleusercontent.com")
                .clientSecret("Zb6qaJIwNweN4RYS_L_qD4BE")
                .build();
    }
}
