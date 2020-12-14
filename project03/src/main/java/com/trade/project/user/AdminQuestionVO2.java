package com.trade.project.user;

public class AdminQuestionVO2 {
	
	private int admin_question_no; // 관리자 Q&A 번호
	private String user_id; // 회원 아이디
	private int qa_no; // Q&A 번호
	private String admin_answer; // 관리자 Q&A 답변
	
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
	public int getQa_no() {
		return qa_no;
	}
	public void setQa_no(int qa_no) {
		this.qa_no = qa_no;
	}
	public String getAdmin_answer() {
		return admin_answer;
	}
	public void setAdmin_answer(String admin_answer) {
		this.admin_answer = admin_answer;
	}
	
}
