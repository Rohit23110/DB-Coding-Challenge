package com.db.grad.javaapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigBasicAuth extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailsService;
    
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/api/v1/user/signup");
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()   
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .httpBasic();
        
    }
    
    @Bean
    public PasswordEncoder getPasswordEncoder() {
    	return new CustomEncoder();
    }
    
}
