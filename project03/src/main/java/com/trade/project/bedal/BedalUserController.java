package com.trade.project.bedal;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BedalUserController {

	@Autowired
	BedalUserService service;

	//회원가입
	@RequestMapping("bedal/bedal_user/joincheck.do")
	public void join(BedalUserVO bedaluserVO) {
		service.join(bedaluserVO);
	}
	
	// 아이디 중복검사
	@RequestMapping("bedal/bedal_user/check_id.do")
	public void check_id(BedalUserVO bedaluserVO, Model model) {
		int result = service.check_id(bedaluserVO);
		model.addAttribute("result", result);
	}
	
	//로그인
	@RequestMapping("bedal/bedal_user/logincheck.do")
		public void login(BedalUserVO bedaluserVO, Model model, HttpSession session) {
		int result = service.login(bedaluserVO);
			model.addAttribute("result", result);
			
			if (result == 1) {
				session.setAttribute("bedal_id", bedaluserVO.getBedal_id()); //${bedal_id}
				
				System.out.println(session.getAttribute("bedal_id"));
			}
		}
	
	
	//마이프로필 수정
	@RequestMapping("bedal/bedal_list/bedal_profile.do")
		public void bedal_profile(BedalUserVO bedaluserVO, HttpSession session) {
		String bedal_id = session.getAttribute("bedal_id")+"";
		bedaluserVO.setBedal_id(bedal_id);
		service.bedal_profile(bedaluserVO);
			System.out.println("controller=============="+bedaluserVO.getBedal_nickname());
		}

}
