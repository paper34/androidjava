package com.trade.project.product;

import java.sql.Date;

public class ReplyVO {
	private int no;
	private String content;
	private int original;
	private String writer;
	private Date date;
	
	
	
	public int getNo() {
		return no;
	}



	public void setNo(int no) {
		this.no = no;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public int getOriginal() {
		return original;
	}



	public void setOriginal(int original) {
		this.original = original;
	}



	public String getWriter() {
		return writer;
	}



	public void setWriter(String writer) {
		this.writer = writer;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "replyVO [no=" + no + ", content=" + content + ", original=" + original + ", writer=" + writer + "]";
	}
	
	
	
}
