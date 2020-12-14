package com.trade.project.algolism.qa;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trade.project.admin.AdminQuestionVO;
import com.trade.project.admin.AdminReportVO;
import com.trade.project.admin.AdminUserVO;
import com.trade.project.user.UserVO;

@Repository
public class AlgolismQaDAO {

	@Autowired
	SqlSessionTemplate mybatis;

	// 추천질문내역 뽑아오기
	public List<AlgolismVO> list_age(String user_id) {
		
		int session_age = mybatis.selectOne("algolismqa.session_age",user_id);
		int session_age2 = (int) Math.floor(session_age / 10);
		AlgolismVO vo = new AlgolismVO();
		vo.setQa_age(session_age2);
		List<AlgolismVO> list_age = mybatis.selectList("algolismqa.list_age",vo);
		return list_age;
	}
	
	public AlgolismVO one(AlgolismVO vo) {
		AlgolismVO one = mybatis.selectOne("algolismqa.detail_algoqa", vo);
		return one;
	}

	
	
	
	
	

}
