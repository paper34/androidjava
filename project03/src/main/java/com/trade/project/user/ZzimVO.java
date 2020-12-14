package com.trade.project.user;

public class ZzimVO {
	
	private int zzim_id; // 찜 id
	private String user_id; // 유저 아이디
	private String product_id; // 상품 id
	private String product_title; // 상품 제목
	private String product_price; // 상품 가격
	private String product_category; // 상품 카테고리

	public int getZzim_id() {
		return zzim_id;
	}

	public void setZzim_id(int zzim_id) {
		this.zzim_id = zzim_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_title() {
		return product_title;
	}

	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}

	public String getProduct_price() {
		return product_price;
	}

	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}


	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

}
