package com.trade.project.algolism.qa;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trade.project.admin.AdminQuestionVO;

@Controller
public class AlgolismQaController {

	@Autowired
	AlgolismQaService service;

	// Q/A추천 알고리즘
	@RequestMapping("admin/qa_algolism.do")
	public void list(Model model, HttpSession session) {
		String user_id = (String) session.getAttribute("user_id");
		List<AlgolismVO> list = service.list_age(user_id);
		model.addAttribute("list", list);

	}

	// Q/A추천 알고리즘 상세
	@RequestMapping("admin/qa_algolismajax.do")
	public void one(AlgolismVO vo, Model model) {
		AlgolismVO one = service.one(vo);
		model.addAttribute("one", one);
	}

}
