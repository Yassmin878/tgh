package com.example.demo.secuirty.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.secuirty.model.Role;
import com.example.demo.secuirty.model.UserRole;

@Repository

public interface userRoleRepository extends JpaRepository<UserRole,Long>{

	@Query(value="SELECT * FROM BPM_ADMINISTRATION.SC_USERROLE WHERE USER_ID = ?1", nativeQuery = true)
	public List<UserRole> getUserRolesById(Long USER_ID);
	
}
