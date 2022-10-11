package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RSB_SubsData;

@Repository
public interface RSB_Repo extends JpaRepository<RSB_SubsData,String> 
{
	@Query(value="select NAME from SUBS_INFO where TELEPHONE_NO=?",nativeQuery = true)
	public String retriveNameByTelNum(String caller_number);
	
	@Query(value="SELECT u FROM SUBS_INFO u WHERE UPPER(TRIM(u.NAME))= UPPER TRIM(?)",nativeQuery = true)
	public RSB_SubsData findBySubject_name(@Param("name")String name);

}
