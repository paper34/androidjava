package com.trade.project.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.project.user.UserVO;

@Service
public class AdminReportService {

	@Autowired
	AdminReportDAO dao;

	public List<AdminReportVO> list() {
		return dao.list();
	}

	public AdminReportVO one(AdminReportVO vo) {
		return dao.one(vo);
	}

	/*
	 * public void update(AdminQuestionVO vo) { dao.update(vo);
	 * 
	 * }
	 */

	public void update(AdminReportVO vo) {
		dao.update(vo);
		
	}
	public void update2(AdminReportVO vo) {
		dao.update2(vo);
	}

}
