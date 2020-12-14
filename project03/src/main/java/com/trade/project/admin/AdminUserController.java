package com.trade.project.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trade.project.user.UserVO;

@Controller
public class AdminUserController {

	@Autowired
	AdminUserService service;
	
	//전체 유저리스트 검색
	@RequestMapping("admin/admin_user.do")
	public void list(Model model) {
		List<AdminUserVO> list = service.list();
		model.addAttribute("list", list);
	}
	
	//유저하나검색(ajax)
	@RequestMapping("admin/admin_userajax.do")
	public void one(AdminUserVO adminuserVO, Model model) {
		AdminUserVO one = service.one(adminuserVO);
		model.addAttribute("one", one);
	}
	
	//해당 아이디 삭제
		@RequestMapping("admin/admin_userdelete.do")
		public void delete(AdminUserVO vo) {
			service.delete(vo);
		}
	
	
	
	

	
	 
	 

}
