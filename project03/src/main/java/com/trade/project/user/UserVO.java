package com.trade.project.user;

import java.sql.Date;

public class UserVO {

	private String user_id; // 회원 아이디
	private String user_pw; // 회원 비밀번호
	private String user_name; // 회원 이름
	private String user_nickname; // 회원 닉네임
	private int user_age; // 회원 나이
	private String user_tel; // 회원 전화번호
	private String user_email; // 회원 이메일
	private String user_address; // 회원 집주소
	private Date user_date; // 회원 가입날짜
	private int user_black; // 회원 블랙유무

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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

	public Date getUser_date() {
		return user_date;
	}

	public void setUser_date(Date user_date) {
		this.user_date = user_date;
	}

	public int getUser_black() {
		return user_black;
	}

	public void setUser_black(int user_black) {
		this.user_black = user_black;
	}

}
