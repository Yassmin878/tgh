package com.example.demo.secuirty.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.secuirty.model.user;

@Repository
public interface user_Repo extends JpaRepository<user, Long> 
{
	@Query(value = "SELECT * FROM BPM_ADMINISTRATION.SC_USERS WHERE lower(USER_NAME) = lower(?)", nativeQuery = true)
	public user findByUsername(String username);
	@Query(value = "SELECT VALUE FROM BPM_ADMINISTRATION.SC_USER_SCOPE WHERE lower(USER_NAME) = lower(?1) AND CODE = ?2", nativeQuery = true)
	List<String> getScopes(String username, String Code);

}
