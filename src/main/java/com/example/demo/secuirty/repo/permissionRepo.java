package com.example.demo.secuirty.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.secuirty.model.UserPermissionId;
import com.example.demo.secuirty.model.permission;

@Repository
public interface permissionRepo extends JpaRepository<permission,UserPermissionId>
{
	@Query(value="SELECT * FROM BPM_ADMINISTRATION.SC_USER_PERMISSION WHERE USER_ID = ?1 and MODULE_ID = ?2", nativeQuery = true)
	public List<permission> getUserPermissionsById(Long USER_ID, Long MODULE_ID);
}
