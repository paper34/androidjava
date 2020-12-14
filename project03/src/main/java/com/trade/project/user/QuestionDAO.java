package com.trade.project.user;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionDAO {

	@Autowired
	SqlSessionTemplate mybatis;

	// Q&A (insert)
	public void report(QuestionVO vo) {
		mybatis.insert("question.insert", vo);
	}

	// Q&A 신고유저 아이디 유무 검사 (check) 현재는 사용X
	public int check_id2(QuestionVO vo) {
		int result = mybatis.selectOne("question.check_id2", vo);
		return result;
	}

	// Q&A (insert) 할때 Admin 답변 Q&A 테이블에 동시 insert
	public void report2(AdminQuestionVO2 vo) {
		mybatis.insert("question.report", vo);
	}

	// Q&A (insert) 할때 Admin 답변 Q&A 테이블에 동시 insert
	public void report3(AdminQuestionVO2 vo) {
		mybatis.insert("question.report2", vo);
	}

	// 마이프로필-유저 구매내역 목록(list)
	public List<PaymentVO2> paylist(String user_id) {
		List<PaymentVO2> list = mybatis.selectList("question.payment", user_id);
		return list;
	}

	// 마이프로필-유저 구매내역에서 매너평가 클릭 시 상품판매한 유저의 user_id 목록을 가져오기
	public List<PaymentVO2> reviewlist(String payment_id) {
		List<PaymentVO2> list = mybatis.selectList("question.reviewlist", payment_id);
		return list;
	}

}
