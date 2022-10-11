package com.example.demo.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.model.TGH_Generator;

public class searchGeneratorTable  implements Specification<TGH_Generator>
{
      private searchObjectForGenerator obj_search;
      
	public searchGeneratorTable(searchObjectForGenerator obj_search) {
		super();
		this.obj_search = obj_search;
	}

	@Override
	public Predicate toPredicate(Root<TGH_Generator> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		List<Predicate>predicates =new ArrayList<>();
		if(obj_search.getCaller_name()!=null && !obj_search.getCaller_name().isEmpty())
		{
			predicates.add(criteriaBuilder.equal(root.get("caller_name"), obj_search.getCaller_name()));
//			System.out.println("*******************************"+obj_search.getCaller_name()+"********************************");
		}
		
		if(obj_search.getCaller_number()!=null && !obj_search.getCaller_number().isEmpty())
		{
			predicates.add(criteriaBuilder.equal(root.get("caller_number"), obj_search.getCaller_number()));
//			System.out.println("*******************************"+obj_search.getCaller_name()+"********************************");
		}
		
		if(obj_search.getThgeneratorid()!=null )
		{
			predicates.add(criteriaBuilder.equal(root.get("thgeneratorid"), obj_search.getThgeneratorid()));
//			System.out.println("*******************************"+obj_search.getCaller_name()+"********************************");
		}
		
//		if(obj_search. getSend_date()!=null )
//		{
//			predicates.add(criteriaBuilder.equal(root.get("send_date"), obj_search. getSend_date()));
////			System.out.println("*******************************"+obj_search.getCaller_name()+"********************************");
//		}
		if(obj_search.getTo_send()!=null&&obj_search.getFrom_send()!=null)
		{
			predicates.add( criteriaBuilder.between(root.get("send_date"), obj_search.getFrom_send(), obj_search.getTo_send()));
		}
		if(obj_search.getTo_call()!=null&&obj_search.getFrom_call()!=null)
		{
			predicates.add( criteriaBuilder.between(root.get("call_date"), obj_search.getFrom_call(), obj_search.getTo_call()));
		}
		
		return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	}

}
