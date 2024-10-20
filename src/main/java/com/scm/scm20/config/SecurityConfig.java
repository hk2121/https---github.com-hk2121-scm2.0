package com.scm.scm20.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.scm.scm20.services.impl.SecurityCustomUserDetailService;

@Configuration
public class SecurityConfig {
    /*
     * // user create and login using java code with in memory service
     * 
     * @Bean
     * public UserDetailsService userDetailsService() {
     * 
     * UserDetails user1 = User
     * .withDefaultPasswordEncoder()
     * .username("admin123")
     * .password("admin123")
     * .roles("ADMIN", "USER")
     * .build();
     * 
     * UserDetails user2 = User
     * .withDefaultPasswordEncoder()
     * .username("user123")
     * .password("password")
     * // .roles()
     * .build();
     * 
     * var inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1,
     * user2);
     * return inMemoryUserDetailsManager;
     * }
     */

    @Autowired
    private SecurityCustomUserDetailService userDetailService;

    // configuration And Authentication provider for spring security
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        // object of user detail service
        daoAuthenticationProvider.setUserDetailsService(userDetailService);
        // object of password encoder
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        // configuration

        // urls ko config.. kiya hai ki whichone is public or private..
        httpSecurity.authorizeHttpRequests(authorize -> {
            // authorize.requestMatchers("/home","/register","/services").permitAll();
            authorize.requestMatchers("/user/**").authenticated();
            authorize.anyRequest().permitAll();
        });

        //form default login
        // need to change something then here we do .. related to form login
        httpSecurity.formLogin(Customizer.withDefaults());
        return httpSecurity.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
