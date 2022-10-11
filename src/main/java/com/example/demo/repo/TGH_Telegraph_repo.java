package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TGH_Telegraph_model;

import java.util.Date;
import java.util.List;

@Repository
public interface TGH_Telegraph_repo extends JpaRepository<TGH_Telegraph_model, Long> ,JpaSpecificationExecutor<TGH_Telegraph_model>
{
    //repo
	
    @Query(value = "select * from TGH_TELEGRAPH where TGH_DATE between ? and ?",nativeQuery = true)
    public List<TGH_Telegraph_model>getBetweenTwoDates(Date d1,Date d2);
}
