package com.trade.project.admin;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminQuestionDAO {

	@Autowired
	SqlSessionTemplate mybatis;

	// admin q/a 리스트
	public List<AdminQuestionVO> list() {
		List<AdminQuestionVO> list = mybatis.selectList("admin_qa.questionlist");
		return list;
	}

	// admin q/a 디테일
	public AdminQuestionVO one(AdminQuestionVO vo) {
		AdminQuestionVO one = mybatis.selectOne("admin_qa.questiondetail", vo);
		return one;
	}

	// admin q/a 답변 저장
	public void update(AdminQuestionVO vo) {
		System.out.println(vo.getAdmin_answer() + "===============>>>>>");
		mybatis.update("admin_qa.questionanswer", vo);
	}

	// admin 유저삭제
	public void delete(AdminQuestionVO vo) {
		mybatis.delete("admin_qa.questiondelete", vo);
	}

}
