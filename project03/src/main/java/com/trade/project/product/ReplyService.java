package com.trade.project.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 컨트롤러에서 db로 넘어가기전/ 결과값 가지고 와서
// 중간에 처리해야하는 부분 : 비지니스 층 (busnis 

@Service
public class ReplyService {
		
	@Autowired
	ReplyDAOInterface dao;
	
	
	public int delete(ReplyVO vo) {
		return dao.delete(vo);
	}
	
	public int create(ReplyVO vo) {
		System.out.println("서비스시작" + vo);
		return dao.create(vo);

	}
	
	
	public List<ReplyVO> list2(int original) {
		return dao.list2(original);
	}
	
	
}
