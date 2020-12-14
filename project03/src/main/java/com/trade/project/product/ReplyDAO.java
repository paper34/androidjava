package com.trade.project.product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// persistence layer (퍼시스턴스 레이어, 층)


@Repository
public class ReplyDAO implements ReplyDAOInterface {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	@Override
	public int delete(ReplyVO vo) {
		int result = mybatis.delete("reply.delete", vo);
		return result;
	}
	
	
	
	@Override
	public int create(ReplyVO vo) {
		System.out.println("다오시작" + vo);
		int result = mybatis.insert("reply.create", vo);
		System.out.println("다오끝" + vo);
		return result;
	}
	
	
	
	@Override
	public List<ReplyVO> list2(int original) {
		List<ReplyVO> list2 =  mybatis.selectList("reply.list", original);
		System.out.println("!!!!!댓글리스트!!!!!");
		System.out.println(list2);
		return list2;
	}




}
