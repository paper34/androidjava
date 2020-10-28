package com.mega.mvc02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	// 컨트롤러 값 받아주기
	@RequestMapping("insert.do")
	public void insert(String id, String pw, String name, String tel) {
		
			// 지금 그냥 값 받았는지 보여주는거임
			System.out.println("id: " + id);
			System.out.println("pw: " + pw);
			System.out.println("name: " + name);
			System.out.println("tel: " + tel);
			
			
		
	}
}
