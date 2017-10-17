package com.gosenk.fantasy.lineups.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Value("${gosenk.oauth.resourceId}")
    private String resourceId;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resourceId);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers(HttpMethod.POST, "/oauth/token").anonymous().
                antMatchers(HttpMethod.POST, "/users/revoketoken").anonymous().
                antMatchers(HttpMethod.POST, "/users").anonymous().
                anyRequest().authenticated();

        /*http.csrf().disable();
        http.httpBasic().disable();

        http.requestMatchers().antMatchers("*//**//**")
                .and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/users/me*//**//**").authenticated()
                .anyRequest().authenticated();*/
    }
}
