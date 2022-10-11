package com.example.demo.model;

import java.util.List;

import javax.management.relation.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Columns;

@Entity
@Table(name="SUBS_INFO")
public class RSB_SubsData 
{
  @Id
  @Column(name="TEL_NO")
  private String telephone_number;
  @Column(name="NAME")
  private String name;

  
  
public RSB_SubsData(String telephone_number, String name) {
	super();
	this.telephone_number = telephone_number;
//	this.subject_name = subject_name;
	this.name = name;
}


public RSB_SubsData() {
	super();
}
public String getTelephone_number() {
	return telephone_number;
}
public void setTelephone_number(String telephone_number) {
	this.telephone_number = telephone_number;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

}
