package com.example.demo.secuirty.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.secuirty.UserPrinciple;
import com.example.demo.secuirty.model.Role;
import com.example.demo.secuirty.model.UserRole;
import com.example.demo.secuirty.model.permission;
import com.example.demo.secuirty.model.user;
import com.example.demo.secuirty.repo.RoleRepo;
import com.example.demo.secuirty.repo.permissionRepo;
import com.example.demo.secuirty.repo.userRoleRepository;
import com.example.demo.secuirty.repo.user_Repo;


@Service
public class UserDetailsServiceImpl  implements UserDetailsService
{

	@Autowired
	private user_Repo userRepository;
	@Autowired
	private RoleRepo roleRepository;
	@Autowired
	private userRoleRepository userRoleRepository;
	@Autowired
	private permissionRepo PermissionRepo;
	
	
	
	public UserDetailsServiceImpl(user_Repo userRepository, RoleRepo roleRepository,
			com.example.demo.secuirty.repo.userRoleRepository userRoleRepository, permissionRepo permissionRepo) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.userRoleRepository = userRoleRepository;
		PermissionRepo = permissionRepo;
	
	}


	@Value("${module.id}")
	private Long MODULE_ID;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		user use = this.userRepository.findByUsername(username);
		System.out.println("\n****password*******\n"+ use.getPassword() +"\n****************\n");
		System.out.println("\n****ID*******\n    "+ use.getUser_id() +"\n***********\n");
		
		if(use == null) 
			
			throw new UsernameNotFoundException("User not found");
		
		
		List<UserRole> userRoles = userRoleRepository.getUserRolesById(use.getUser_id());
		List<Role> roles = new ArrayList<Role>();
	
			userRoles.forEach(r -> { roles.add(roleRepository.getById(r.getROLE_ID()));});
			use.setRoles(roles);
					
//		return  new org.springframework.security.core.userdetails.User(use.getUser_name(), use.getPassword(),k );
			
		List<permission> userPermissions = PermissionRepo.getUserPermissionsById(use.getUser_id(), MODULE_ID);
		use.setPermissions(userPermissions);
		
		UserPrinciple userPrincipal = new UserPrinciple(use);

        return userPrincipal;

		
	}

}
