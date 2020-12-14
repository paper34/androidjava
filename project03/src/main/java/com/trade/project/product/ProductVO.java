package com.trade.project.product;

import java.sql.Date;
import java.sql.Timestamp;

import com.sun.javafx.collections.MappingChange.Map;

public class ProductVO {
	private int product_id;//상품아이디(넘버)
	private String product_title;//상품이름0
	private String product_content;//상품설명0
	private String product_image;//상품이미지0
	private int product_price;//상품가격0
	private String product_category;//상품카테고리0
	private String product_adress;//상품카테고리0
	private Date product_date;//상품등록시간
	private int product_count;//상품조회
	private int product_status;//상품조회
	private String user_id;//상품조회
	
	
	public int getProduct_status() {
		return product_status;
	}
	public void setProduct_status(int product_status) {
		this.product_status = product_status;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_title() {
		return product_title;
	}
	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}
	public String getProduct_content() {
		return product_content;
	}
	public void setProduct_content(String product_content) {
		this.product_content = product_content;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	public String getProduct_adress() {
		return product_adress;
	}
	public void setProduct_adress(String product_adress) {
		this.product_adress = product_adress;
	}
	public Date getProduct_date() {
		return product_date;
	}
	public void setProduct_date(Date product_date) {
		this.product_date = product_date;
	}
	public int getProduct_count() {
		return product_count;
	}
	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "ProductVO [product_id=" + product_id + ", product_title=" + product_title + ", product_content="
				+ product_content + ", product_image=" + product_image + ", product_price=" + product_price
				+ ", product_category=" + product_category + ", product_adress=" + product_adress + ", product_date="
				+ product_date + ", product_count=" + product_count + ", product_status=" + product_status
				+ ", user_id=" + user_id + "]";
	}
	
	 
	

	
	
	
	

}
