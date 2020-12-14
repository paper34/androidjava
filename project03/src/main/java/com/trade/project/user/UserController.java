package com.trade.project.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trade.project.admin.AdminUserVO;

@Controller
public class UserController {

	@Autowired
	UserService service;
	
	// 알고리즘 완료한 service
	@Autowired
	AlgoService service2;
	
	
	// 회원가입 Controller
	@RequestMapping("user/login/joincheck.do")
	public void join(UserVO userVO, AdminUserVO adminuserVO) {
		service.join(userVO);   // user테이블 insert  
		service.adminjoin(adminuserVO); // admin_user테이블 insert 
	}

	// 회원가입-아이디 중복검사
	@RequestMapping("user/login/check_id.do")
	public void check_id(UserVO userVO, Model model) {
		int result = service.check_id(userVO);
		model.addAttribute("result", result);
	}

	// 로그인
	@RequestMapping("user/login/logincheck.do")
	public void login(UserVO userVO, HttpServletRequest request, Model model, HttpSession session) {
		int result = service.login(userVO); // result 0,1?
		model.addAttribute("result", result);
		System.out.println(result);
		// result의 값이 1이면 로그인성공!
		if (result == 1) {
			// 성공 시 입력학 user_id를 세션에 저장
			session.setAttribute("user_id", userVO.getUser_id());
		}
		
	}

	// 상품 detail 화면에서 찜 버튼 누르면 insert or delete
	@RequestMapping("user/profile/zzimcheck.do")
	public void zzim_check(ZzimVO zzimVO, Model model) {
		int result = service.zzim_check(zzimVO);
		model.addAttribute("result", result);
		
		// result = 1  , 찜이 되어있는 상태이기 때문에 삭제(delete)
		if (result == 1) {
			service.zzim_delete(zzimVO);
			// 찜 삭제
		} else {
			service.zzim(zzimVO);
			// 찜 추가
		}
	}

	// 마이프로필-유저 찜목록(list)
	@RequestMapping("user/profile/myprofile_zzim.do")
	public void zzim_list(String user_id, Model model, AlgoVO vo) {
		// 찜 view에서 해당 유저가 찜한 목록을 가져옴
		List<ZzimVO> zzim = service.zzim_list(user_id);
		model.addAttribute("zzim", zzim);
		
		// 찜한 테이블에서 유저의 나이와 상품을 등록한 유저의 나이 / 가격 을 점수로 환산해 
		// 유저에게 상품을 맞춤추천하는 리스트
		List<AlgoVO> list = service2.algolist(vo);
		model.addAttribute("algolist", list);
		
	}
	
	
	// 마이프로필-유저 매너평가 목록(list)
	@RequestMapping("user/profile/myprofile_review.do")
	public void user_review(String user_id, Model model) {
		List<UserReviewVO> user = service.user_review(user_id);
		model.addAttribute("user", user);
	}

}
