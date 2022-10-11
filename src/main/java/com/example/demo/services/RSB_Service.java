//package com.example.demo.services;
//
//import java.text.CollationKey;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import javax.management.relation.Role;
//
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.security.core.GrantedAuthority;
////import org.springframework.security.core.authority.SimpleGrantedAuthority;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.model.RSB_SubsData;
//import com.example.demo.repo.RSB_Repo;
//
//import javassist.Loader.Simple;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//
//@Service
//@AllArgsConstructor
//@NoArgsConstructor
//
//public class RSB_Service  implements UserDetailsService
//{   @Autowired
//	private RSB_Repo rsp_repo;
//	 private List< Role >kkk;
////	@Override
////	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////		RSB_SubsData obj= rsp_repo.findBySubject_name(username);
////		if (obj==null)
////			throw new UsernameNotFoundException("invalid user name)");
////		else
//////			Collection<GrantedAuthority>gg= new ArrayList<>();
////		kkk.forEach(kk ->
////		{ 
////			gg.add(new SimpleGrantedAuthority(kk.getRoleName()));
////		}
////		);
////		
////			return new org.springframework.security.core.userdetails.User(obj.getSubject_name(), obj.getTelephone_number(), mapto(obj.getKk()));
////			
////		
////	}
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
////	private static List<GrantedAuthority> mapto(List<Role> roles)
////	{
////		List<GrantedAuthority>gg= new ArrayList<>();
////				return gg;  
////		
////	}
//}
