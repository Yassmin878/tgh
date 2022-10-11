package com.example.demo.services;

public class concat_Rec_Sender 
{
	private	Long sender_id;
	private Long recepient_id;
	public Long getSender_id() {
		return sender_id;
	}
	public void setSender_id(Long sender_id) {
		this.sender_id = sender_id;
	}
	public Long getRecepient_id() {
		return recepient_id;
	}
	public void setRecepient_id(Long recepient_id) {
		this.recepient_id = recepient_id;
	}
	public concat_Rec_Sender() {
		super();
		// TODO Auto-generated constructor stub
	}
	public concat_Rec_Sender(Long sender_id, Long recepient_id) {
		super();
		this.sender_id = sender_id;
		this.recepient_id = recepient_id;
	}
	
	

}
