package com.trade.project.product;

import java.sql.Date;

public class PaymentVO {
	private int payment_id;	
	private String user_id;	
	private int product_id;	
	private int product_price;	
	private Date payment_date;	
	private int payment_delivery;
	
	
	
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
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
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
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
	@Override
	public String toString() {
		return "PaymentVO [payment_id=" + payment_id + ", user_id=" + user_id + ", product_id=" + product_id
				+ ", product_price=" + product_price + ", payment_date=" + payment_date + ", payment_delivery="
				+ payment_delivery + "]";
	}
	
	
	
	
	
}
