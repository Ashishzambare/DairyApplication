package com.dairyproject.DairyApplication.config;

import com.dairyproject.DairyApplication.Apputil.PasswordEncrypter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;





@Configuration
public class SecurityConfig {
        @Bean
        public PasswordEncrypter encoder(){
            return new PasswordEncrypter();
        }
}
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorize -> authorize
//
//                        .requestMatchers("/public/**").permitAll() // Adjust other endpoints as necessary
//                        .anyRequest().authenticated()// Protect other endpoints
//                )
//                .csrf(csrf->csrf.disable());// Disable CSRF for simplicity (only do this in non-production environments)
//
//
//        return http.build();
//    }
//
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new InMemoryUserDetailsManager(
//                User.withUsername("user")
//                        .password(passwordEncoder().encode("password"))
//                        .roles("USER")
//                        .build()
//        );
//    }
//
//
//    @Bean
//    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder =
//               http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder
//                .inMemoryAuthentication().withUser("user")
//                .password(passwordEncoder().encode("password"))
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("ADMIN");
//
//        return authenticationManagerBuilder.build();
//    }

