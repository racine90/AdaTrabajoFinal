package com.ada.blog.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {

	protected LoginFilter(String url, AuthenticationManager authManager) {
	super(new AntPathRequestMatcher(url)); // con este contructor se pasa la url "/login"
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
	throws AuthenticationException, IOException, ServletException {
		InputStream body = request.getInputStream();

	Usuario user = new ObjectMapper().readValue(body, Usuario.class);

		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(user.getUsuario(),
			user.getContraseña(), Collections.emptyList()));

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		JwtUtil.addAuthentication(response,authResult.getName()); // si la autenticacacion fue exitosa se genera el token
	}

}
