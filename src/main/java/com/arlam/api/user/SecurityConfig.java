package com.arlam.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final OAuth2UserService oAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
            .and()
                .authorizeRequests()
                .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**","/hello/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
            .and()
                .logout()
                    .logoutSuccessUrl("/")
            .and()
                .oauth2Login()
                    .userInfoEndpoint()
                        .userService(oAuth2UserService);
    }
}
