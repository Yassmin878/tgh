package com.example.demo.secuirty.filters;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.auth0.jwt.JWT;
import com.example.demo.secuirty.constrain.JWT_class;
import com.example.demo.secuirty.constrain.loginView;
import com.example.demo.secuirty.repo.user_Repo;

public class athuntication_filter extends UsernamePasswordAuthenticationFilter
{
	
    private AuthenticationManager auth_manager;
	private user_Repo repo_user;                            // (2)

	
	 
	public athuntication_filter(AuthenticationManager auth_manager, user_Repo repo_user) {
		super();
		this.auth_manager = auth_manager;
		this.repo_user = repo_user;
	}
	// 1. implement for 2 override methods           (attemptAuthentication)      (successfulAuthentication)
   	
	                                                          // (1)
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		loginView lv=null;
		try {
			lv=new ObjectMapper().readValue(request.getInputStream(), loginView.class);
		} catch (IOException e) {
		e.printStackTrace();
		}
		// 2. Create login token by UsernamePasswordAuthenticationToken
		UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken
				(lv.getUsername(), lv.getPassword(), new ArrayList<>());
		// 3.return authenticate
		
		 System.out.println("attemptAuthentication");

		Authentication auth = auth_manager.authenticate(token);
		return auth;
	}
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
          // 1. create object from UserDetails	
		UserDetails principle= (UserDetails)authResult.getPrincipal();
//		/////////////////////////////////////////////////////////////////////////////////
	
	     List<String> scopes = repo_user.getScopes(principle.getUsername(), "REP_BUILDER_SCOPE");		
	        
	        String scopesConcat = "";
	        for(int i = 0; i < scopes.size(); i++) {
	        	if(i == scopes.size() - 1)
	        		scopesConcat += scopes.get(i);
	        	else
	        		scopesConcat += scopes.get(i) + ';';		
	        }

	        
	        Map<String, String> scopesPayload = new HashMap<>();
	        scopesPayload.put("scopes", scopesConcat);
	        
         // 2. create JWT token
		String token =JWT.create()
				.withSubject(principle.getUsername())
				.withPayload(scopesPayload)
				.withExpiresAt(new Date(System.currentTimeMillis()+JWT_class.Expiration_time))
				.withIssuer(request.getRequestURL().toString())
				.withClaim("roles", principle.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(HMAC512(JWT_class.secret.getBytes()));
        // 3. create map  key --> header , value --> prefix+ token 
	Map<String, String> jwt_token= new HashMap<>();
	jwt_token.put(JWT_class.headet_string, JWT_class.token_prefix + token);
	response.setContentType("application/json");
	new ObjectMapper().writeValue(response.getOutputStream(), jwt_token);
	
	
	}
	

}
