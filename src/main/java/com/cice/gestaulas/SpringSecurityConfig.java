package com.cice.gestaulas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.cice.gestaulas.auth.handler.LoginSuccessHandler;
import com.cice.gestaulas.services.impl.JpaUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{	
		
	@Bean
	public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
	    return new LoginSuccessHandler();
	}	
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/**", "/css/**", "/js/**", "/images/**").permitAll()
		.anyRequest().authenticated()
		.and()
		    .formLogin()		    	
		    	.loginPage("/login").permitAll()
		        .successHandler(myAuthenticationSuccessHandler())		        
		    .permitAll()
		.and()
		.logout()			
		.and()
		.exceptionHandling().accessDeniedPage("/login")
		.and()		
		.csrf()
        .disable();

	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception
	{
		build.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
	}
}
