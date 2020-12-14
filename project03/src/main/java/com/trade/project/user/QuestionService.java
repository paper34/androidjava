package com.trade.project.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

	@Autowired
	QuestionDAO dao;

	// Q&A (insert)
	public void report(QuestionVO vo) {
		dao.report(vo);
	}

	// Q&A 신고유저 아이디 유무 검사 (check) 현재는 사용X
	public int check_id2(QuestionVO vo) {
		int result = dao.check_id2(vo);
		return result;
	}

	// Q&A (insert) 할때 Admin 답변 Q&A 테이블에 동시 insert
	public void report2(AdminQuestionVO2 vo) {
		dao.report2(vo);
	}

	// Q&A (insert) 할때 Admin 답변 Q&A 테이블에 동시 insert
	public void report3(AdminQuestionVO2 vo) {
		dao.report3(vo);
	}

	// 마이프로필-유저 구매내역 목록(list)
	public List<PaymentVO2> paylist(String user_id) {
		return dao.paylist(user_id);
	}

	// 마이프로필-유저 구매내역에서 매너평가 클릭 시 상품판매한 유저의 user_id 목록을 가져오기
	public List<PaymentVO2> reviewlist(String payment_id) {
		return dao.reviewlist(payment_id);
	}

}
