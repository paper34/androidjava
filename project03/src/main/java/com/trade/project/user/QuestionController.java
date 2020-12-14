package com.trade.project.user;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestionController {

	@Autowired
	QuestionService service;

	// Q&A (insert) 할때 Admin 답변 Q&A 테이블에 동시 insert
	@RequestMapping("user/q&a/report_success.do")
	public void report(QuestionVO questionVO, AdminQuestionVO2 adminquestionVO) {
		service.report(questionVO); // Q&A (insert)
		service.report2(adminquestionVO); // AdminQ&A (insert)
		service.report3(adminquestionVO);
	}

	// Q&A 신고유저 아이디 유무 검사 (check) 현재는 사용X
	@RequestMapping("user/checkR_id.do")
	public void check_id(QuestionVO questionVO, Model model) {
		int result = service.check_id2(questionVO);
		model.addAttribute("result", result);
	}

	// 마이프로필-유저 구매내역 목록(list)
	@RequestMapping("user/profile/myprofile_buy.do")
	public void paylist(String user_id, Model model) {
		 List<PaymentVO2> list =  service.paylist(user_id);
		model.addAttribute("list", list);
	}
	
	// 마이프로필-유저 구매내역에서 매너평가 클릭 시 상품판매한 유저의 user_id 목록을 가져오기
	@RequestMapping("user/profile/myprofile_estimate.do")
	public void reviewlist(String payment_id, Model model) {
			List<PaymentVO2> review = service.reviewlist(payment_id);
			 model.addAttribute("review", review);
	}

}
