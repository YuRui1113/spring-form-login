/*
 * File: src\main\java\com\taylor\springformlogin\config\security\SecurityConfig.java
 * Project: spring-form-login
 * Created Date: Thursday, December 28th 2023, 11:29:23 am
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Thursday, 28th December 2023 8:57:58 pm
 * Modified By: Rui Yu (yurui_113@hotmail.com>)
 * -----
 * Copyright (c) 2023 Rui Yu
 * -----
 * HISTORY:
 * Date                     	By       	Comments
 * -------------------------	---------	----------------------------------------------------------
 * Thursday, December 28th 2023	Rui Yu		Initial version
 */

package com.taylor.springformlogin.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        public static final String[] ENDPOINTS_WHITELIST = {
                        "/css/**",
                        "/js/**",
                        "/font-awesome/**",
                        "/bootstrap-5.2.3-dist/css/**",
                        "/",
                        "/index",
                        "/login"
        };

        @Bean
        public UserDetailsService users(PasswordEncoder passwordEncoder) {
                UserDetails user1 = User.withUsername("user1")
                                .password("$2a$10$lDUTwo3pS6bt7Iwv4oVmPuM3hfYNKdddurzv4xBpvzk31RS7LfS72")
                                .roles("USER")
                                .build();
                UserDetails user2 = User.withUsername("user2")
                                .password("$2a$10$lDUTwo3pS6bt7Iwv4oVmPuM3hfYNKdddurzv4xBpvzk31RS7LfS72")
                                .roles("USER", "ADMIN")
                                .build();
                UserDetails admin = User.withUsername("admin")
                                .password("$2a$10$lDUTwo3pS6bt7Iwv4oVmPuM3hfYNKdddurzv4xBpvzk31RS7LfS72")
                                .roles("ADMIN")
                                .build();
                return new InMemoryUserDetailsManager(user1, user2, admin);
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http.authorizeHttpRequests(
                                authorize -> authorize
                                                // We are permitting all static resources to be accessed publicly
                                                .requestMatchers(ENDPOINTS_WHITELIST)
                                                .permitAll()
                                                .requestMatchers("/user/**").hasRole("USER")
                                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                                .requestMatchers("/anonymous").anonymous()
                                                .anyRequest()
                                                .authenticated())
                                // Default form login
                                // .formLogin(Customizer.withDefaults())
                                .formLogin(login -> {
                                        login.loginPage("/login")
                                                        .usernameParameter("username")
                                                        .passwordParameter("password")
                                                        // 当直接访问login页面时，认证成功会访问index页面
                                                        // 如果访问其它需要登录的页面时则会返回初始页面，比如/，认证成功会返回/
                                                        .defaultSuccessUrl("/index")
                                                        .failureUrl("/login?error=true")
                                                        .permitAll();
                                })
                                .logout(logout -> {
                                        logout
                                                        .logoutSuccessUrl("/login?logout=true")
                                                        .invalidateHttpSession(true)
                                                        .deleteCookies("JSESSIONID");
                                })
                                .exceptionHandling(exception -> {
                                        exception
                                                        .accessDeniedPage("/accessDenied");
                                });

                return http.build();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }
}