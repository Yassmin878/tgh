//package com.example.demo.model;
//
//import java.awt.print.Pageable;
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//import com.example.demo.repo.search_object;
//import com.google.common.base.Objects;
//
////TGH_Telegraph_modelSpecs
//@Service
//public class searching
//{
//	    @PersistenceContext
//	    private final EntityManager entityManager;
//	    private final CriteriaBuilder criteriaBuilder;
//
//	    public searching(EntityManager entityManager) {
//	        this.entityManager = entityManager;
//	        this.criteriaBuilder = entityManager.getCriteriaBuilder();
//	    }
//
//	    // class name
//	    public Page<TGH_Telegraph_model> findAllWithFilter(PagingObject pagingObject, List<search_object> search_object) {
//	        // class name 1
//	        CriteriaQuery<TGH_Telegraph_model> criteriaQuery = criteriaBuilder.createQuery(TGH_Telegraph_model.class);
//	        // class name 2
//	        Root<TGH_Telegraph_model> disputeRoot = criteriaQuery.from(TGH_Telegraph_model.class);
//	        Predicate predicates = getPredicates( disputeRoot, search_object);
//	        criteriaQuery.where(predicates);
//	        setOrder(pagingObject, criteriaQuery, disputeRoot);
//	        TypedQuery<TGH_Telegraph_model> typedQuery = entityManager.createQuery(criteriaQuery);
//	        typedQuery.setFirstResult(pagingObject.getPageNumber() * pagingObject.getPageSize());
//	        typedQuery.setMaxResults(pagingObject.getPageSize());
//	        Pageable pageable = getPageable(pagingObject);
//	        Long disputeCount = getDisputeCount(predicates);
//	        Page<TGH_Telegraph_model> obj = new PageImpl<>(typedQuery.getResultList(), pageable, disputeCount);
//	        return obj;
//	    }
//
//	    private Long getDisputeCount(Predicate predicates) {
//	        // class name 3
//	        CriteriaQuery countQuery = criteriaBuilder.createQuery(TGH_Telegraph_model.class);
//	        Root<DISPUTE_CODE_DESCRIPTION> countRoot = countQuery.from(TGH_Telegraph_model.class);
//	        countQuery.select(criteriaBuilder.count(countRoot)).where(predicates);
//	        return (Long) entityManager.createQuery(countQuery).getSingleResult();
//	    }
//
//
//	    private void setOrder(PagingObject pagingObject, CriteriaQuery<TGH_Telegraph_model> criteriaQuery, Root<TGH_Telegraph_model> disputeRoot) {
//	        if (pagingObject.getSortDirection().equals(Sort.Direction.ASC)) {
//	            criteriaQuery.orderBy(criteriaBuilder.asc(disputeRoot.get(pagingObject.getSortBy())));
//	        } else {
//	            criteriaQuery.orderBy(criteriaBuilder.desc(disputeRoot.get(pagingObject.getSortBy())));
//	        }
//	    }
//
//	    private Pageable getPageable(PagingObject pagingObject) {
//	        Sort sort = Sort.by(pagingObject.getSortDirection(), pagingObject.getSortBy());
//	        return PageRequest.of(pagingObject.getPageNumber(), pagingObject.getPageSize(), sort);
//	    }
//
//	    //class name
//	    public Predicate getPredicates( Root<TGH_Telegraph_model> disputeRoot, List<search_object> search_object) {
//	        List<Predicate> predicates = new ArrayList()<>();
//
//	        for (search_object criteria : search_object) {
//
//	            if (Objects.nonNull(criteria.getValue()) ){
//	                if (criteria.getOperation().equals(SearchOperation.GREATER_THAN)) {
//	                    predicates.add(criteriaBuilder.greaterThan(
//	                            disputeRoot.get(criteria.getKey()), criteria.getValue().toString()));
//	                } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN)) {
//	                    predicates.add(criteriaBuilder.lessThan(
//	                            disputeRoot.get(criteria.getKey()), criteria.getValue().toString()));
//	                } else if (criteria.getOperation().equals(SearchOperation.GREATER_THAN_EQUAL)) {
//	                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(
//	                            disputeRoot.get(criteria.getKey()), criteria.getValue().toString()));
//	                } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN_EQUAL)) {
//	                    predicates.add(criteriaBuilder.lessThanOrEqualTo(
//	                            disputeRoot.get(criteria.getKey()), criteria.getValue().toString()));
//	                } else if (criteria.getOperation().equals(SearchOperation.NOT_EQUAL)) {
//	                    predicates.add(criteriaBuilder.notEqual(
//	                            disputeRoot.get(criteria.getKey()), criteria.getValue()));
//	                }
//	                if (criteria.getOperation().equals(SearchOperation.EQUAL)) {
//	                    if (criteria.getValue() instanceof Double) {
//	                        Double value = (Double) criteria.getValue();
//	                        predicates.add(criteriaBuilder.equal(
//	                                disputeRoot.get(criteria.getKey()), value ));
//	                    }
//	                    else  if (criteria.getValue() instanceof Date  && ! criteria.getValue().toString().isEmpty())
//	                    {
//	                        Date d = (Date) criteria.getValue();
//	                        predicates.add(criteriaBuilder.equal(
//	                                disputeRoot.get(criteria.getKey()), d ));
//	                    }
//	                    else if (criteria.getValue() instanceof Integer)
//	                    {
//	                        predicates.add(criteriaBuilder.equal(
//	                                disputeRoot.get(criteria.getKey()), criteria.getValue()));
//	                    }
//	                    else if (criteria.getValue() instanceof String)
//	                    {
//	                        predicates.add(criteriaBuilder.equal(
//	                                disputeRoot.get(criteria.getKey()), criteria.getValue().toString()));
//	                    }
//	                    else
//	                    {
//	                        predicates.add(criteriaBuilder.equal(
//	                                disputeRoot.get(criteria.getKey()), criteria.getValue()));
//
//	                    }
//
//	                }
//	                else if (criteria.getOperation().equals(SearchOperation.MATCH)) {
//	                    predicates.add(
//	                            criteriaBuilder.like(disputeRoot.get(criteria.getKey()),
//	                                    "%" + criteria.getValue().toString() + "%"));
//	                } else if (criteria.getOperation().equals(SearchOperation.MATCH_END)) {
//	                    predicates.add(criteriaBuilder.like(
//	                            disputeRoot.get(criteria.getKey()),
//	                            criteria.getValue().toString() + "%"));
//	                }
//	                else if (criteria.getOperation().equals(SearchOperation.MATCH_START)) {
//	                    predicates.add(criteriaBuilder.like(
//	                            disputeRoot.get(criteria.getKey()),
//	                            "%" + criteria.getValue()));
//	                }
//	                else if (criteria.getOperation().equals(SearchOperation.IN)) {
//	                    predicates.add(criteriaBuilder.in(disputeRoot.get(criteria.getKey())).value(criteria.getValue()));
//	                } else if (criteria.getOperation().equals(SearchOperation.NOT_IN)) {
//	                    predicates.add(criteriaBuilder.not(disputeRoot.get(criteria.getKey())).in(criteria.getValue()));
//	                }
//	                else if (criteria.getOperation().equals(SearchOperation.BETWEEN)){
//	                    List<Date> DateList  = (List<Date>) criteria.getValue();
//	                    try{
//	                        predicates.add(criteriaBuilder.between(disputeRoot.get(criteria.getKey()), DateList.get(0) , DateList.get(1)));
//	                    }catch (Exception e)
//	                    {
//	                        System.out.println("exception in between operation Failed ");
//	                    }
//	                }
//	            }
//	        }
//	        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//	    }
//	}
//
//}
