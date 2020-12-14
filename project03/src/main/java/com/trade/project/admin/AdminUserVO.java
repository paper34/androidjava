package com.trade.project.admin;

public class AdminUserVO {
	private int admin_userno;
	private String user_id; // 회원 id   1
	private String user_pw; // 회원 pw   2
	private String user_name; // 이름    3
	private String user_nickname; // 닉네임  4
	private int user_age; // 나이   5
	private String user_tel; // 전화번호   6
	private String user_email; // 이메일  8
	private String user_address; // 집주소  9
	private String user_date; //회원 가입 날짜 10
	private String user_status; // 회원 가입 여부 11
	private int user_black; //유저 블랙 여부 12
	
	
	public int getUser_black() {
		return user_black;
	}
	public void setUser_black(int user_black) {
		this.user_black = user_black;
	}
	public int getAdmin_userno() {
		return admin_userno;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_date() {
		return user_date;
	}
	public void setUser_date(String user_date) {
		this.user_date = user_date;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	public void setAdmin_userno(int admin_userno) {
		this.admin_userno = admin_userno;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	

}
