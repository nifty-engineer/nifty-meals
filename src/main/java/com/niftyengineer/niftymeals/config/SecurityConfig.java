package com.niftyengineer.niftymeals.config;

import com.niftyengineer.niftymeals.security.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    private final UserAuthnEntryPoint userAuthnEntryPoint;
    private final UserAuthnProvider userAuthnProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
          .exceptionHandling(exception ->
            exception
              .authenticationEntryPoint(userAuthnEntryPoint))
          .cors(Customizer.withDefaults())
          .csrf(AbstractHttpConfigurer::disable)
          .sessionManagement(httpSecuritySessionManagementConfigurer ->
            httpSecuritySessionManagementConfigurer
              .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
          .authorizeHttpRequests(requests ->
            requests
//              .requestMatchers(HttpMethod.POST, "/api/register", "/api/login").permitAll()
              .requestMatchers("/api/meals/member/**")
              .authenticated()
              .anyRequest()
              .permitAll()
          )
          .addFilterBefore(new JwtAuthFilter(userAuthnProvider), BasicAuthenticationFilter.class);
        return http.build();
    }
}