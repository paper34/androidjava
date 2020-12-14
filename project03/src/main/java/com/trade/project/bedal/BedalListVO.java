package com.trade.project.bedal;

public class BedalListVO {

	String bedal_list_id; // 배달목록 아이디
	String product_id;// 상품 아이디
	String product_title;// 상품명
	String user_id;// 유저 아이디
	String user_address;// 유저 주소
	int payment_id;// 결제 아이디
	int bedal_list_status; //배송상태
	String payment_price;// 결제 금액
	String payment_date;// 결제 날짜
	String product_image;//상품이미지
	String bedal_image;//증명사진
	String bedal_id;//배달 아이디
	String user_email; //유저 이메일
	String user_name; //유저 이름 

	public String getBedal_id() {
		return bedal_id;
	}

	public void setBedal_id(String bedal_id) {
		this.bedal_id = bedal_id;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public void setBedal_list_status(int bedal_list_status) {
		this.bedal_list_status = bedal_list_status;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public String getBedal_list_id() {
		return bedal_list_id;
	}

	public void setBedal_list_id(String bedal_list_id) {
		this.bedal_list_id = bedal_list_id;
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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public String getPayment_price() {
		return payment_price;
	}

	public void setPayment_price(String payment_price) {
		this.payment_price = payment_price;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public int getBedal_list_status() {
		return bedal_list_status;
	}

	public String getBedal_image() {
		return bedal_image;
	}

	public void setBedal_image(String bedal_image) {
		this.bedal_image = bedal_image;
	}
	

}
