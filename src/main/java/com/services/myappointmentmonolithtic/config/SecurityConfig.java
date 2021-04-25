package com.services.myappointmentmonolithtic.config;

import com.services.myappointmentmonolithtic.constants.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin1").password("$2y$12$EKM.RF./xFlieyDkKqwza.y6Kz0EYQq0Pt.y4RGA1SXJHjgj738/y").roles(Role.ADMIN.toString())
                .and()
                .withUser("admin2").password("$2y$12$Ybwa/FzdZEeZ5Qro7aVgVOk9sNKqAgfXWpwbfwPUzR8sQJ3/j0Uwm").roles(Role.ADMIN.toString())
                .and()
                .withUser("client1").password("$2y$12$b16LKu1M2M53wS5/uCqsMOFiA1qp.ndg4LPTqlLuolNlbqizxHJWa").roles(Role.CLIENT.toString())
                .and()
                .withUser("client2").password("$2y$12$r8euND6pHDYBPc3UKT.YCu3lGRF5YA6KIJc3fnFh3wyH5iaqKb.eG").roles(Role.CLIENT.toString())
                .and()
                .withUser("employee1").password("$2y$12$HEYeL3Tnxh5gwa0jeorZS.4P4lJTF6bpMjs4JJ1rAAJZ1WVsEBdTW").roles(Role.EMPLOYEE.toString())
                .and()
                .withUser("employee2").password("$2y$12$j1KNmBTxdDpZflUg8r4voO555WuuDDSDxlV7qxPYmLNnZazXR18Ry").roles(Role.EMPLOYEE.toString());

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login*").anonymous()
                .antMatchers("/users/**").hasAnyRole(Role.ADMIN.toString(), Role.CLIENT.toString(),Role.EMPLOYEE.toString())
                .antMatchers("/users*").anonymous()
                .antMatchers("/providedservice/**").anonymous()
                .antMatchers("/booking/**").permitAll()
                .antMatchers("/").anonymous()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/account", true)
                .failureUrl("/home");
//                .and()
//                .logout()
//                .logoutUrl("/home");
//                .deleteCookies("JSESSIONID");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
