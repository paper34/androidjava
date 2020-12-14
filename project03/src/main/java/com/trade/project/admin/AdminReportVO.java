package com.trade.project.admin;

public class AdminReportVO {
	private int admin_report_no;
	private int qa_no;
	private String user_id;
	private String qa_title;
	private String qa_content;
	private String qa_date;
	private String user_name;
	private char qa_status;
	private String qa_service;
	private String report_id;
	private char user_black;
	
	public char getUser_black() {
		return user_black;
	}
	public void setUser_black(char user_black) {
		this.user_black = user_black;
	}
	
	public String getReport_id() {
		return report_id;
	}
	public void setReport_id(String report_id) {
		this.report_id = report_id;
	}
	public String getQa_service() {
		return qa_service;
	}
	public void setQa_service(String qa_service) {
		this.qa_service = qa_service;
	}
	public char getQa_status() {
		return qa_status;
	}
	public void setQa_status(char qa_status) {
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
	
	public int getAdmin_report_no() {
		return admin_report_no;
	}
	public void setAdmin_report_no(int admin_report_no) {
		this.admin_report_no = admin_report_no;
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

	public String getQa_date() {
		return qa_date;
	}
	public void setQa_date(String qa_date) {
		this.qa_date = qa_date;
	}

	
	
}
