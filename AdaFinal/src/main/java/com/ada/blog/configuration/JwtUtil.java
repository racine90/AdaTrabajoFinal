package com.ada.blog.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static java.util.Collections.emptyList;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

	static void addAuthentication(HttpServletResponse response, String username) {
		String token = Jwts.builder().setSubject(username).signWith(SignatureAlgorithm.HS512, "R@cine").compact(); // hash
																													// firma
																													// del
																													// token
		response.addHeader("Authorization", "Bearer" + token); // Encabezado del token
	}

	static Authentication getAuthentication(HttpServletRequest request) {

		String token = request.getHeader("Authentization"); // se obtiene el token que viene del encabezado

		if (token != null) {
			String user = Jwts.parser().setSigningKey("R@cine").parseClaimsJws(token.replace("Bearer", "")).getBody()
					.getSubject(); /// si hay un token se valida
			return user != null ? new UsernamePasswordAuthenticationToken(user, null, emptyList()) : null;
		}
		return null;
	}

}
