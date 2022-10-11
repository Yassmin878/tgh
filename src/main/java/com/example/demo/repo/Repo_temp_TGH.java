package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TGH_Template;


@Repository

public interface Repo_temp_TGH extends JpaRepository<TGH_Template,String> {

	@Query(name="select * from TGH_TEMPLATE where TEMP_TYPE_CODE=?",nativeQuery = true)
	public List<TGH_Template> getByCode(String code);

}
