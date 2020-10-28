package com.mega.mvc03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {
	
	
	@Autowired
	MemberDAO dao;
	
	@Autowired
	discount dis;
	
	@RequestMapping("reply.do")
	public void reply(String reply, Model model) {
		// db처리했음.
		// views로 넘어감.
		model.addAttribute("reply", reply);
	}
	
	@RequestMapping("id.do")
	public String login(String id, Model model) {
		
		id = dis.login(id);	
		model.addAttribute("id", id);
		
		return "id";
		
	}
	
	@RequestMapping("movie.do")
	public String movie(String title, int price, Model model) {
		System.out.println("영화제목: " + title + "가격: " + price);
		
		price = dis.sale(price);
		
		model.addAttribute("title", title);
		model.addAttribute("price", price);
		
		return "like";
				
	}
	
			
}
