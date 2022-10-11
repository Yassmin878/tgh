package com.example.demo.API_Exception;

import java.time.LocalDateTime;
//import java.time.ZonedDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
public class ApiException {

	protected LocalDateTime timestamp;
	protected int statusCode;
	protected HttpStatus status;
	protected String reason;
//	protected String clientMessage;
//	protected String developerMessage;
//	protected Object body;
//	protected Map<?, ?> data;
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
//	public String getClientMessage() {
//		return clientMessage;
//	}
//	public void setClientMessage(String clientMessage) {
//		this.clientMessage = clientMessage;
//	}
//	public String getDeveloperMessage() {
//		return developerMessage;
//	}
//	public void setDeveloperMessage(String developerMessage) {
//		this.developerMessage = developerMessage;
//	}
//	public Object getBody() {
//		return body;
//	}
//	public void setBody(Object body) {
//		this.body = body;
//	}
//	public Map<?, ?> getData() {
//		return data;
//	}
//	public void setData(Map<?, ?> data) {
//		this.data = data;
//	}
//	
}
////@Data
////@NoArgsConstructor
////@AllArgsConstructor
//public class ApiException 
//{
//	
//private final String message; 
//private final Throwable throwable;
//private final HttpStatus httpStatus;
//private final ZonedDateTime times;
//
//public ApiException() {
//	
//	super();
//	this.message = "";
//	this.throwable = new Throwable();
//	this.httpStatus = null;
//	this.times = null;
//	// TODO Auto-generated constructor stub
//}
//public ApiException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime times) {
//	super();
//	this.message = message;
//	this.throwable = throwable;
//	this.httpStatus = httpStatus;
//	this.times = times;
//}
//
//public String getMessage() {
//	return message;
//}
//public Throwable getThrowable() {
//	return throwable;
//}
//public HttpStatus getHttpStatus() {
//	return httpStatus;
//}
//public ZonedDateTime getTimes() {
//	return times;
//}
//
//
//}
