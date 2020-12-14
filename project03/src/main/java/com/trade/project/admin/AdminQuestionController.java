package com.trade.project.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trade.project.user.UserVO;

@Controller
public class AdminQuestionController {

	@Autowired
	AdminQuestionService service;

	// 질문 리스트 검색
	@RequestMapping("admin/admin_question.do")
	public void list(Model model) {
		List<AdminQuestionVO> list = service.list();
		model.addAttribute("list", list);
	}

	// 질문 상세 검색(ajax),답변저장
	@RequestMapping("admin/admin_questionajax.do")
	public void one(AdminQuestionVO adminqavo, Model model) {
		AdminQuestionVO one = service.one(adminqavo);
		model.addAttribute("one", one);
	}

	// 답변업데이트
	@RequestMapping("admin/question_answer.do")
	public void update(AdminQuestionVO vo) {
		service.update(vo);
		System.out.println("controller>>>"+vo.getQa_status());
		System.out.println("controller>>>"+vo.getAdmin_answer());
    }

	// 해당 아이디 삭제
	@RequestMapping("admin/admin_questiondelete.do")
	public void delete(AdminQuestionVO vo) {
		service.delete(vo);
	}

}
