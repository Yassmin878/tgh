package com.example.demo.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Sender;

@Repository
public interface Sender_Repo extends JpaRepository<Sender, Long>
{
	@Transactional
	@Modifying
	@Query(value="INSERT INTO TGH_SENDER (SENDER_NAME,GEN_ID,BILL_TEL_NO)  VALUES(?,?,?) ",nativeQuery = true)
	public void sender_info(String name,Long gen_id,String telNo);
	
	@Query(value="SELECT TGH_SENDER_SEQ.NEXTVAL FROM DUAL",nativeQuery = true)
	public Long getSenderLastId();

}
