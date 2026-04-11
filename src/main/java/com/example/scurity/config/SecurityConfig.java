package com.example.scurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * No-op security configuration — permits all requests.
 *
 * -----------------------------------------------------------------------
 * JWT INTEGRATION POINT
 * -----------------------------------------------------------------------
 * When adding Spring Security + JWT, replace this class with:
 *
 *   1. A JwtAuthenticationFilter extends OncePerRequestFilter that:
 *      - Extracts the Bearer token from the Authorization header
 *      - Validates the token signature and expiry
 *      - Populates the SecurityContextHolder with an Authentication object
 *
 *   2. An AuthenticationProvider (e.g. DaoAuthenticationProvider) wired to
 *      your UserDetailsService implementation.
 *
 *   3. Update the filterChain below to:
 *      - Set sessionManagement to STATELESS
 *      - Add .authorizeHttpRequests() rules (e.g. permit /auth/**, secure the rest)
 *      - Register the JwtAuthenticationFilter before UsernamePasswordAuthenticationFilter
 *
 *   4. Expose an AuthenticationManager bean for use in your /auth/login endpoint.
 * -----------------------------------------------------------------------
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth ->
                        // TODO: Replace with role-based rules when JWT is implemented
                        auth.anyRequest().permitAll());

        return http.build();
    }
}
