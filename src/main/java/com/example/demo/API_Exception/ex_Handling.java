//package com.example.demo.API_Exception;
//
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
////import lombok.val;
//@ControllerAdvice
//public class ex_Handling 
//{
//	@ExceptionHandler(value={Exception_catching.class})
//public ResponseEntity<Object>handle_Req_Ex( Exception_catching e)
//{
////	create payload containing ex details
//	ApiException apiException=new ApiException(e.getMessage(),e,HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z")));
////	 return response entity
//	return new ResponseEntity<>(apiException,HttpStatus.BAD_REQUEST);
//	
//}
//	
//}
