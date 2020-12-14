package com.trade.project.admin;

public class AdminQuestionVO {
	private int admin_question_no;
	private int qa_no;
	private String user_id;
	private String qa_title;
	private String qa_content;
	private String admin_answer;
	private String qa_date;
	private String user_name;
	private int qa_status;
	private String qa_service;
	
	
	public String getQa_service() {
		return qa_service;
	}
	public void setQa_service(String qa_service) {
		this.qa_service = qa_service;
	}
	public int getQa_status() {
		return qa_status;
	}
	public void setQa_status(int qa_status) {
		this.qa_status = qa_status;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getQa_no() {
		return qa_no;
	}
	public void setQa_no(int qa_no) {
		this.qa_no = qa_no;
	}
	
	public int getAdmin_question_no() {
		return admin_question_no;
	}
	public void setAdmin_question_no(int admin_question_no) {
		this.admin_question_no = admin_question_no;
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
	public String getQa_content() {
		return qa_content;
	}
	public void setQa_content(String qa_content) {
		this.qa_content = qa_content;
	}
	public String getAdmin_answer() {
		return admin_answer;
	}
	public void setAdmin_answer(String admin_answer) {
		this.admin_answer = admin_answer;
	}
	public String getQa_date() {
		return qa_date;
	}
	public void setQa_date(String qa_date) {
		this.qa_date = qa_date;
	}

	
	
}
