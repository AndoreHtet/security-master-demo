package com.example.secuirtymasterdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        var uds= new InMemoryUserDetailsManager();
        var john = User.withUsername("john")
                .password("john")
                .roles("SUPER_ADMIN").build();

        var emma = User.withUsername("emma")
                .password("emma")
                .roles("EMPLOYEE_ADMIN").build();

        var lucas = User.withUsername("lucas")
                .password("lucas")
                .roles("DEPARTMENT_READ","DEPARTMENT_WRITE")
                .build();

        var richard = User.withUsername("richard")
                .password("richard")
                .roles("CUSTOMER_READ"). build();

        var james = User.withUsername("james")
                .password("james")
                .roles().build();
        uds.createUser(john);
        uds.createUser(emma);
        uds.createUser(lucas);
        uds.createUser(richard);
        uds.createUser(james);
        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}