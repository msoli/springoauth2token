package com.example.config;

import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
@Slf4j
//@Order(-20)
public class LoginConfig extends WebSecurityConfigurerAdapter {

//    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

//    @Autowired
//    public LoginConfig(CustomAuthenticationEntryPoint customAuthenticationEntryPoint) {
//        this.customAuthenticationEntryPoint = customAuthenticationEntryPoint;
//
//    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .formLogin().loginPage("/login").permitAll()

//                .and()
//                .exceptionHandling()
//                .authenticationEntryPoint(customAuthenticationEntryPoint)
                .and()
                .logout().invalidateHttpSession(true).clearAuthentication(true).deleteCookies("JSESSIONID","SESSION","XSRF-TOKEN")
//                .logoutUrl("/oauth/logout")
//                .and()
//                .csrf()
//                .requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize"))
//                .disable()
//                .headers()
//                .frameOptions().disable()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)

                .and()
                .requestMatchers()
                .antMatchers("/", "/login", "/logout", "/oauth/authorize", "/oauth/confirm_access")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
        ;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
//                .parentAuthenticationManager(authenticationManagerBean())
                .inMemoryAuthentication().withUser("Peter").password("peter").roles("USER");
    }


}
