package com.mega.mvc05;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	
	@Autowired
	SqlSessionTemplate mybatis;
	
	public void insert(MemberVO vo) {
		mybatis.insert("member.create", vo);
	}

	public void delete(MemberVO vo) {
		mybatis.delete("member.delete", vo);
	}

	public void update(MemberVO vo) {
		mybatis.update("member.update", vo);
	}

	public MemberVO select(MemberVO vo) {
		MemberVO vo2 = mybatis.selectOne("member.one", vo);
		return vo2;
	}

	public List<MemberVO> list() {
		List<MemberVO> list = mybatis.selectList("member.list");
		return list;
	}
}
