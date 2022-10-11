//package com.example.demo.model;
//
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
//public class PagingObject 
//{
//	 private int pageNumber= 0 ;
//	    private int pageSize = 10 ;
//	    private Sort.Direction sortDirection  = Sort.Direction.DESC;
//	    private String sortBy = "DISPUTE_ID";
//
//	    public PagingObject(int pageNumber, int pageSize, String sortBy) {
//	        this.pageNumber = pageNumber;
//	        this.pageSize = pageSize;
//	        this.sortBy = sortBy;
//	    }
//
//		public int getPageNumber() {
//			return pageNumber;
//		}
//
//		public void setPageNumber(int pageNumber) {
//			this.pageNumber = pageNumber;
//		}
//
//		public int getPageSize() {
//			return pageSize;
//		}
//
//		public void setPageSize(int pageSize) {
//			this.pageSize = pageSize;
//		}
//
//		public Sort.Direction getSortDirection() {
//			return sortDirection;
//		}
//
//		public void setSortDirection(Sort.Direction sortDirection) {
//			this.sortDirection = sortDirection;
//		}
//
//		public String getSortBy() {
//			return sortBy;
//		}
//
//		public void setSortBy(String sortBy) {
//			this.sortBy = sortBy;
//		}
//
//		public PagingObject() {
//			super();
//			// TODO Auto-generated constructor stub
//		}
//
//		public PagingObject(int pageNumber, int pageSize, Direction sortDirection, String sortBy) {
//			super();
//			this.pageNumber = pageNumber;
//			this.pageSize = pageSize;
//			this.sortDirection = sortDirection;
//			this.sortBy = sortBy;
//		}
//	    
//}
