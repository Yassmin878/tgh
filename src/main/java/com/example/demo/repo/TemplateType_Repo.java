package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TGH_TemplateType;


@Repository

public interface TemplateType_Repo extends JpaRepository <TGH_TemplateType,String>
{

}
