package com.ramisecurityauth.voucherappwithdbAuth.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.httpBasic();
        http.authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/voucherapi/vouchers/**","/","/showGetVoucher","/getVoucher")
                .hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.GET, "/showCreateVoucher","/createVoucher","/createResponse")
                .hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST,"/voucherapi/vouchers","/saveVoucher")
                .hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST,"/getVoucher")
                .hasAnyRole("USER","ADMIN")
                .and()
                .csrf().disable();
        return http.build();
    }

}
