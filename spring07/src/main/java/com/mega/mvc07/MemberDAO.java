package com.mega.mvc07;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

//@Bean
//@Component (컴포넌트 == bean)  부모클래스!

@Repository
public class MemberDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	public void insert(MemberVO vo) {
		int result = mybatis.insert("member.insert", vo);
		System.out.println("result: " + result);
	}
	
	public void update(MemberVO vo) {
		int result =mybatis.update("member.update", vo);
		System.out.println("result: " + result);
	}
	
	public void delete(MemberVO vo) {
		int result = mybatis.delete("member.delete", vo);
		System.out.println("result: " + result);
	}
	public MemberVO one(MemberVO vo) {
		 MemberVO vo2 = mybatis.selectOne("member.one", vo);
		 					// (네임스페이스이름.id, 입력 param)
		 return vo2;
	}
	
	public java.util.List<MemberVO> list() {
		java.util.List<MemberVO> list = mybatis.selectList("member.list");
		System.out.println("list.size: " + list.size());
		return list;
	}
	
	
}
