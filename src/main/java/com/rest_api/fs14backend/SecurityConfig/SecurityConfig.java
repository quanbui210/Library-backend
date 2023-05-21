package com.rest_api.fs14backend.SecurityConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

/*  @Autowired
  private JwtFilter jwtFilter;*/

//  @Bean
//  public AuthenticationManager authenticationManager(
//    AuthenticationConfiguration authenticationConfiguration
//  ) throws Exception {
//    return authenticationConfiguration.getAuthenticationManager();
//  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .csrf()
      .disable()
      .authorizeHttpRequests()
      .requestMatchers("/signup")
      .permitAll()
      .anyRequest()
      .authenticated()
      .and()
      .httpBasic(withDefaults());

    return http.build();
  }
}
