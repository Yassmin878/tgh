package com.example.demo.repo;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.model.TGH_Telegraph_model;

import org.springframework.util.StringUtils;
public class Search_specification implements Specification<TGH_Telegraph_model> 
{
	private search_object obj_search;

	
	public Search_specification(search_object obj_search) {
		super();
		this.obj_search = obj_search;
	}

	@Override
	public Predicate toPredicate(Root<TGH_Telegraph_model> root, CriteriaQuery<?> query,CriteriaBuilder criteriaBuilder)
	{
		List<Predicate>predicates =new ArrayList<>();
		
		if(obj_search.getCaller_name()!=null && !obj_search.getCaller_name().isEmpty())
		{
			predicates.add(criteriaBuilder.equal(root.get("caller_name"), obj_search.getCaller_name()));
			System.out.println("*******************************"+obj_search.getCaller_name()+"********************************");
		}
		if(obj_search.getAddress()!=null && ! obj_search.getAddress().isEmpty())
		{
			predicates.add(criteriaBuilder.equal(root.get("address"), obj_search.getAddress()));
		}
		if(obj_search.getGen_id()!=null  )
		{
			predicates.add(criteriaBuilder.equal(root.get("gen_id"), obj_search.getGen_id()));
		}
		if(obj_search.getId()!=null  )
		{
			predicates.add(criteriaBuilder.equal(root.get("id"), obj_search.getId()));
		}
		if( obj_search.getFrom()!=null && obj_search.getTo()!=null)
		{
			predicates.add( criteriaBuilder.between(root.get("tgh_date"), obj_search.getFrom(), obj_search.getTo()));
		
		}

//		for (int i=0;i<predicates.size();i++)
//		{
//		System.out.println("********************************"+ predicates.indexOf(i)+"********************************");
//		}
		return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	}
	
	

}

