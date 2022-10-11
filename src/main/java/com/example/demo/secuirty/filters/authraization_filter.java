package com.example.demo.secuirty.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.example.demo.secuirty.UserPrinciple;
import com.example.demo.secuirty.constrain.JWT_class;
import com.example.demo.secuirty.model.Role;
import com.example.demo.secuirty.model.UserRole;
import com.example.demo.secuirty.model.permission;
import com.example.demo.secuirty.model.user;
import com.example.demo.secuirty.repo.RoleRepo;
import com.example.demo.secuirty.repo.permissionRepo;
import com.example.demo.secuirty.repo.userRoleRepository;
import com.example.demo.secuirty.repo.user_Repo;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;


public class authraization_filter extends BasicAuthenticationFilter
{	
	
	private user_Repo userRepository;
	
	private RoleRepo roleRepository;
	private userRoleRepository userRoleRepository;
	
	private permissionRepo userPermissionRepo;

	@Value("${module.id}")
	private Long MODULE_ID;

	public authraization_filter(AuthenticationManager authenticationManager, user_Repo userRepository,
			RoleRepo roleRepository, com.example.demo.secuirty.repo.userRoleRepository userRoleRepository,
			permissionRepo userPermissionRepo) {
		super(authenticationManager);
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.userRoleRepository = userRoleRepository;
		this.userPermissionRepo = userPermissionRepo;
	}

	public authraization_filter(AuthenticationManager authenticationManager, user_Repo userRepository,
			RoleRepo roleRepository, com.example.demo.secuirty.repo.userRoleRepository userRoleRepository,
			permissionRepo userPermissionRepo, Long mODULE_ID) {
		super(authenticationManager);
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.userRoleRepository = userRoleRepository;
		this.userPermissionRepo = userPermissionRepo;
		MODULE_ID = mODULE_ID;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String header= request.getHeader(JWT_class.headet_string);
		 if (header == null || !header.startsWith(JWT_class.token_prefix))
		 {
			 chain.doFilter(request, response);
		 
		 return;
		 }
		 Authentication authentication = getUsernamePasswordAuthentication(request);
		 SecurityContextHolder.getContext().setAuthentication(authentication); /////******/////
		 chain.doFilter(request, response);
	}
	
	 private Authentication getUsernamePasswordAuthentication(HttpServletRequest request)
	 {
	        String token = request.getHeader(JWT_class.headet_string)
	                .replace(JWT_class.token_prefix,""); 
	        if (token != null) {
	        	String username=JWT.require(HMAC512(JWT_class.secret.getBytes())).build().verify(token).getSubject();
	        	
	        	 if (username != null) {
	                 user user = userRepository.findByUsername(username);
	                 
	                 if(user != null) {
	                 	// get user roles and permissions 
	                 	// then load them in the object user
	                 	List<com.example.demo.secuirty.model.UserRole> userRoles = userRoleRepository.getUserRolesById(user.getUser_id());
	                 	List<Role> roles = new ArrayList<Role>();
	                 	userRoles.forEach(r -> {
	                 		roles.add(roleRepository.getById(r.getROLE_ID()));
	                 	});
	                 	user.setRoles(roles);
	                 	
	                 	List<permission> userPermissions = userPermissionRepo.getUserPermissionsById(user.getUser_id(), MODULE_ID);
	                 	user.setPermissions(userPermissions);
	                 	
	                 	UserPrinciple principal = new UserPrinciple(user);
	                 	UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null, principal.getAuthorities());
	                 	return auth;                	
	                 }
	                 else {
	                 	
	                 	user = new user();
	                 	user.setUser_name(username);
	                 	user.setRoles(new ArrayList<>());
	                 	user.setPermissions(new ArrayList<>());
	                 	UserPrinciple principal = new UserPrinciple(user);
	                 	UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null, principal.getAuthorities());
	                 	return auth; 
	                 }
	                 
	             }
	             return null;
	         }
	         return null;
	     
	 }
	
}
