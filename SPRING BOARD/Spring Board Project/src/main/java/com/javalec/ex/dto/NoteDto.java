package com.javalec.ex.dto;

import java.sql.Timestamp;

public class NoteDto {
	 int Id;
	 String Sender;
	 String Receiver;
	 String Content;
	 int Confirm;
	 Timestamp Sendtime;
	 Timestamp Checktime;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getSender() {
		return Sender;
	}
	public void setSender(String sender) {
		Sender = sender;
	}
	public String getReceiver() {
		return Receiver;
	}
	public void setReceiver(String receiver) {
		Receiver = receiver;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public int getConfirm() {
		return Confirm;
	}
	public void setConfirm(int confirm) {
		Confirm = confirm;
	}
	public Timestamp getSendtime() {
		return Sendtime;
	}
	public void setSendtime(Timestamp sendtime) {
		Sendtime = sendtime;
	}
	public Timestamp getChecktime() {
		return Checktime;
	}
	public void setChecktime(Timestamp checktime) {
		Checktime = checktime;
	}
	
	
}
