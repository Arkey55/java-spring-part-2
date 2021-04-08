package ru.romankuznetsov.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/v1/person/addperson").hasRole("SUPER_ADMIN")
                .antMatchers("/api/v1/person/").hasAnyRole("ADMIN", "SUPER_ADMIN")
                .antMatchers("/api/v1/product/").hasAnyRole("ADMIN", "MANAGER", "SUPER_ADMIN")
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/authenticateTheUser").permitAll();

    }
}

