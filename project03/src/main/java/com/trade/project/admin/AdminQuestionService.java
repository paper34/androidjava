package com.trade.project.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.project.user.UserVO;

@Service
public class AdminQuestionService {

	@Autowired
	AdminQuestionDAO dao;

	public List<AdminQuestionVO> list() {
		return dao.list();
	}

	public AdminQuestionVO one(AdminQuestionVO vo) {
		return dao.one(vo);
	}

	public void update(AdminQuestionVO vo) {
		System.out.println(vo.getAdmin_answer()+"====================");
		dao.update(vo);
		
	}

	public void delete(AdminQuestionVO vo) {
		dao.delete(vo);
	}

}
