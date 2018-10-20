//package com.fr.adaming.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.session.SessionRegistry;
//import org.springframework.security.core.session.SessionRegistryImpl;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.session.HttpSessionEventPublisher;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		/*
//		 * auth.inMemoryAuthentication().withUser("admin").password("1234").roles(
//		 * "ADMIN", "USER").and().withUser("user") .password("1234").roles("USER");
//		 */
//
//		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		http.sessionManagement().maximumSessions(1).sessionRegistry(sessionRegistry());
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		//http.formLogin();
//		http.authorizeRequests().antMatchers("/api/dossier/chartQuantitativeFiltredByDate/**","/topic/notification","/websocket/Systemalerte/**","/api/monitoringLogs", "/runtime.js","/scripts.js","/styles.js","/polyfills.js"
//				,"/assets/**","/glyphicons-halflings-regular.woff2","/glyphicons-halflings-regular.woff","/glyphicons-halflings-regular.ttf","/vendor.js","/main.js","/login","/index.html","/js/**","/img/**","/css/**","/static/img/**","static/**").permitAll();
//		http.authorizeRequests().antMatchers("/static/img/**","/api/account/reset_password/init/**",
//											"/api/account/reset_password/finish/**",
//											"/api/startProcess","/login","/index.html",
//											"/js/**","/img/**","/css/**").permitAll();
//		http.authorizeRequests().anyRequest().authenticated();
//		http.addFilter(new JWTAuthentificationFilter(authenticationManager()));
//		http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
//		
//		
//	}
//
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//		return source;
//	}
//
//	@Bean
//	public SessionRegistry sessionRegistry() {
//		return new SessionRegistryImpl();
//	}
//
//	@Bean
//	public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
//		return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
//	}
//
//}
