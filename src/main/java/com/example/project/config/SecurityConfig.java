package com.example.project.config;

import com.example.project.repository.UserRepository;
import com.example.project.service.AppUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                //which urls are visible by which users
                authorizeRequests -> authorizeRequests
                        //all static resources which are situated in js, images, css are visible for anyone
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        //allow anyone to see the pages
                        .requestMatchers("/", "/home", "/about", "/destinations", "/contacts",
                                "/register", "/login", "/fonts/**", "/plugins/**").permitAll()
                        //all other requests are authenticated
                        .anyRequest().authenticated()
        ).formLogin(
                formLogin -> {
                    formLogin
                            //redirect here when we access something which is not allowed
                            .loginPage("/login")
                            //the name of the input fields (in login.hml)
                            .usernameParameter("email")
                            .passwordParameter("password")
                            .defaultSuccessUrl("/home", true)
                            .failureForwardUrl("/login-error");
                }
        ).logout(
                logout -> {
                    logout
                            // the url where we should POST something in order to perform the logout
                            .logoutUrl("/logout")
                            // where to go when logged out
                            .logoutSuccessUrl("/home")
                            // invalidate the http session
                            .invalidateHttpSession(true);
                }
        );
        //TODO: remember me!

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        //translates the users and roles to representation which spring security understands
        return new AppUserDetailsService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
