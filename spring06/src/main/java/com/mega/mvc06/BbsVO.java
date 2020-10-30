package com.mega.mvc06;

public class BbsVO {
	private String no;
	private String writer;
	private String title;
	private String content;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "BbsVO [no=" + no + ", writer=" + writer + ", title=" + title + ", content=" + content + "]";
	}
	
	
}
