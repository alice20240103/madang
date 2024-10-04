package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .requiresChannel()
                .anyRequest()
                .requiresSecure() // 모든 요청을 HTTPS로 강제
            .and()
            .authorizeHttpRequests()
                .anyRequest()
                .permitAll(); // 모든 요청 허용 (필요에 따라 조정 가능)

        return http.build();
    }
}
