package com.example.demo.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TGH_Recepient;

@Repository
public interface Recepient_Repo extends JpaRepository<TGH_Recepient, Long>{
	@Transactional
	@Modifying
	
	@Query(value="INSERT INTO TGH_RECEPIENT (REC_NAME,GEN_ID,REC_TEL_NO)  VALUES(?,?,?) ",nativeQuery = true)
	public void Recepient_info(String name,Long gen_id,String telNo);
	@Query(value=" SELECT TGH_RECEPIENT_SEQ1.NEXTVAL FROM DUAL",nativeQuery = true)
	public Long getRecLastId();
}
