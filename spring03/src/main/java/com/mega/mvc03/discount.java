package com.mega.mvc03;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class discount {
	
	@Autowired // 자동으로 값받기?
	MemberDAO dao;
	
	public int sale(int price) {
		
		price =  price - 1000;
		
		return price;
	}
	
	public String login( String id) {
		
		String[] id2 =  {"root", "admin", "apple", "melon", "mint"};
		
		
		String result = "<font color=blue>회원가입가능</font><br>";
		for (int i = 0; i < id2.length; i++) {
			if (id.equals(id2[i])) {
				result= "<font color=red>회원가입불가</font><br>";
			}
			
		}
		 
		return result;
	}
	
	
	
}
