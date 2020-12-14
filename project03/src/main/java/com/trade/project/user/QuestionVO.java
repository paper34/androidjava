package com.trade.project.user;


public class QuestionVO {
	private int qa_no; // Q&A 번호
	private String user_id; // 회원 아이디
	private String qa_title; // Q&A 제목
	private String qa_date; // Q&A 날짜
	private String qa_content; // Q&A 내용
	private String qa_service; // Q&A 유형
	private String report_id; // Q&A 신고유저 아이디
	public int getQa_no() {
		return qa_no;
	}
	public void setQa_no(int qa_no) {
		this.qa_no = qa_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getQa_title() {
		return qa_title;
	}
	public void setQa_title(String qa_title) {
		this.qa_title = qa_title;
	}
	public String getQa_date() {
		return qa_date;
	}
	public void setQa_date(String qa_date) {
		this.qa_date = qa_date;
	}
	public String getQa_content() {
		return qa_content;
	}
	public void setQa_content(String qa_content) {
		this.qa_content = qa_content;
	}
	public String getQa_service() {
		return qa_service;
	}
	public void setQa_service(String qa_service) {
		this.qa_service = qa_service;
	}
	public String getReport_id() {
		return report_id;
	}
	public void setReport_id(String report_id) {
		this.report_id = report_id;
	}
	
	
	
	
	
	
}
