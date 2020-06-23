package com.ada.blog.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ada.blog.service.UsuarioService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("usuarioservice")
	private UsuarioService userdetailservice;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userdetailservice); // por cada autenticacion se deberia buscar en la base mapeada
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception { // HttpSecurity==nos permite crear querys
		http.csrf().disable().authorizeRequests().antMatchers("/login").permitAll() // permite acceso a /login a
																					// cualquiera
				.anyRequest().authenticated() // todas las peticiones requieren autenticacion
				.and()
				.addFilterBefore(new LoginFilter("/login", authenticationManager()),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);// filtro para
																								// validacionde token
	}

	@Override
	public void configure(org.springframework.security.config.annotation.web.builders.WebSecurity web)
			throws Exception {
		web.ignoring().antMatchers("/v2/api-docs/**");
		web.ignoring().antMatchers("/swagger.json");
		web.ignoring().antMatchers("/swagger-ui.html");
		web.ignoring().antMatchers("/swagger-resources/**");
		web.ignoring().antMatchers("/webjars/**");

	}

}
