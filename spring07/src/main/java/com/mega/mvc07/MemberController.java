package com.mega.mvc07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping("one2.do")
	public void one2(MemberVO memberVO, Model model) {
		 MemberVO vo = service.one(memberVO);
		 model.addAttribute("vo", vo);
	}
	
	@RequestMapping("list2.do")
	public void list2(Model model) {
		List<MemberVO> list = service.list();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("create2.do")
	public void create2(MemberVO memberVO) {
		service.insert(memberVO);
	}
	
	@RequestMapping("delete.do")
	public void delete2(MemberVO memberVO) {
		service.delete(memberVO);
	}
	@RequestMapping("update.do")
	public void update2(MemberVO memberVO) {
		service.update(memberVO);
	}
}
