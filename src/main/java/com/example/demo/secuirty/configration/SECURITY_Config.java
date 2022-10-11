package com.example.demo.secuirty.configration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.secuirty.PasswordEnconder;
import com.example.demo.secuirty.filters.athuntication_filter;
import com.example.demo.secuirty.filters.authraization_filter;
import com.example.demo.secuirty.repo.RoleRepo;
import com.example.demo.secuirty.repo.permissionRepo;
import com.example.demo.secuirty.repo.userRoleRepository;
import com.example.demo.secuirty.repo.user_Repo;
import com.example.demo.secuirty.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity

//@EnableGlobalMethodSecurity(prePostEnabled =true)// for  autherazation
public class SECURITY_Config extends WebSecurityConfigurerAdapter 
{	
	@Value("${module.id}")
	private Long MODULE_ID;
	
//	@Value("${LDAP.userFilter}")
//	private String ldap_filter_name;
//	@Value("${LDAP.groupFilter}")
//	private String idap_group_search;
//	@Value("${LDAP.url}")
//	private String ldap_url;
//	@Value("${LDAP.managerDN}")
//	private String idap_manager_DN;
//	@Value("${LDAP.managerPassword}")
//	private String idap_manager_password;
	
	
	private user_Repo userRepository;
	private RoleRepo roleRepository;
	private userRoleRepository userRoleRepository;
	private permissionRepo PermissionRepo;	
	private UserDetailsServiceImpl user_srevice;
	
	public SECURITY_Config(user_Repo userRepository, RoleRepo roleRepository,
			userRoleRepository userRoleRepository, permissionRepo permissionRepo,
			UserDetailsServiceImpl user_srevice) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.userRoleRepository = userRoleRepository;
		PermissionRepo = permissionRepo;
		this.user_srevice = user_srevice;
	}
	
	@Bean
	    DaoAuthenticationProvider authenticationProvider(){
		 System.out.println("authenticationProvider");
	        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
	        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
	        daoAuthenticationProvider.setUserDetailsService(this.user_srevice);

	        return daoAuthenticationProvider;
	    }

//	 @Bean(name="myPasswordEncoder")
//	  PasswordEncoder getPasswordEncoder() {
//	         DelegatingPasswordEncoder delPasswordEncoder=  (DelegatingPasswordEncoder)PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	         BCryptPasswordEncoder bcryptPasswordEncoder =new BCryptPasswordEncoder();
//	     delPasswordEncoder.setDefaultPasswordEncoderForMatches(bcryptPasswordEncoder);
//	     return delPasswordEncoder;      
//	 }
	    @Bean
	    PasswordEncoder passwordEncoder() {
	        return new PasswordEnconder();
	    }
	    
	    
//	    @Bean
//	    BCryptPasswordEncoder passwordEncoder() {
//	        return new BCryptPasswordEncoder();
//	    }


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.authenticationProvider(authenticationProvider());

		
	}
	 
//   @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilter(new athuntication_filter(authenticationManager(),this.userRepository))
        .addFilter(new authraization_filter(authenticationManager(),this.userRepository,this.roleRepository,this.userRoleRepository,this.PermissionRepo,MODULE_ID))
		.authorizeRequests()
	    .antMatchers(HttpMethod.POST,"/login").permitAll() // don't need token to make login (authentication).
		.anyRequest().authenticated()
		.and().httpBasic();
	 	http.cors();
	}
		
//	@Autowired
//	private void Configureglobal(AuthenticationManagerBuilder auth) throws Exception
//	{
//		auth.userDetailsService(user_srevice).passwordEncoder(passwordEncoder());
//	}
	
}
