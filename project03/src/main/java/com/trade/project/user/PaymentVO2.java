package com.trade.project.user;

import java.util.Date;

public class PaymentVO2 {
	
	private String payment_id; // 결제 id
	private String user_id; // 회원 아이디
	private int product_id; // 상품 id
	private int payment_price; // 상품 가격
	private Date payment_date; // 결제 날짜
	private int payment_delivery; // 결제 상태
	private String product_title; // 상품 제목
	public String getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getPayment_price() {
		return payment_price;
	}
	public void setPayment_price(int payment_price) {
		this.payment_price = payment_price;
	}
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	public int getPayment_delivery() {
		return payment_delivery;
	}
	public void setPayment_delivery(int payment_delivery) {
		this.payment_delivery = payment_delivery;
	}
	public String getProduct_title() {
		return product_title;
	}
	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}
	
	
	
}
