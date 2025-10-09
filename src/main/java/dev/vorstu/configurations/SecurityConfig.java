package dev.vorstu.configurations;

import dev.vorstu.entity.Role;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(autz -> autz
                .requestMatchers("/api/login", "/api/logout").permitAll()
                        .requestMatchers("/api/base/students/**").hasAuthority(Role.STUDENT.name())
                .anyRequest().authenticated())
                .httpBasic(basic -> basic
                        .authenticationEntryPoint(new AuthenticationEntryPoint() {
                            @Override
                            public void commence(HttpServletRequest request, HttpServletResponse response,
                                                 AuthenticationException authException){
                                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                            }
                        })
                )
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable());

        return http.build();
    }



    @Autowired
    public void configureAuthentification(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery(
                        "select username, p.password as password, enable "
                        + "from users as u "
                        + "inner join passwords as p on u.password_id = p.id "
                        + "where username=?")
                .authoritiesByUsernameQuery("select username, role from users where username=?")
                .rolePrefix("");
    }

}
