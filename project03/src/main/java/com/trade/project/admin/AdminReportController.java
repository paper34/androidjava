package com.trade.project.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trade.project.user.UserVO;

@Controller
public class AdminReportController {

	@Autowired
	AdminReportService service;

	// 신고 리스트 검색
	@RequestMapping("admin/admin_report.do")
	public void list(Model model) {
		List<AdminReportVO> list = service.list();
		model.addAttribute("list", list);
	}

	// 신고 상세 검색(ajax)
	@RequestMapping("admin/admin_reportajax.do")
	public void one(AdminReportVO vo, Model model) {
		AdminReportVO one = service.one(vo);
		model.addAttribute("one", one);
	}

	/*
	 * // 답변업데이트
	 * 
	 * @RequestMapping("admin/question_answer.do") public void update(AdminReportVO
	 * vo) { service.update(vo);
	 * System.out.println("controller>>>"+vo.getQa_status()); }
	 */

	// 해당 유저 블랙
	@RequestMapping("admin/admin_user_report.do")
	public void update(AdminReportVO vo) {
		service.update(vo); // 블랙
		
	}

	// 해당 유저 블랙
	@RequestMapping("admin/admin_user_release.do")
	public void update2(AdminReportVO vo) {
		service.update2(vo); // 해제
	}

}
