package org.example.config;

import org.example.repository.UserRepository;
import org.example.service.impl.UserServiceImpl;
import org.example.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserServiceImpl userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(request-> {
                        request.requestMatchers(antMatcher("/auth/login")).permitAll();
                        request.requestMatchers(antMatcher("/auth/**")).permitAll();
                        request.requestMatchers(antMatcher("/logedin/**")).authenticated();
                        request.requestMatchers(PathRequest.toH2Console()).permitAll();
                        request.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll();
                    })
                    .formLogin(login -> {
                        login.loginPage("/auth/login");
                        login.defaultSuccessUrl("/logedin/books");
                    });


            return http.build();




    }





    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvicer = new DaoAuthenticationProvider();
        authProvicer.setUserDetailsService(userService);
        authProvicer.setPasswordEncoder(passwordEncoder());
        return authProvicer;
    }


}


