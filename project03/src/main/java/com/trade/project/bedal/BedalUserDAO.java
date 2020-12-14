package com.trade.project.bedal;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BedalUserDAO implements BedalUserInterface {

	@Autowired
	SqlSessionTemplate mybatis;

	// 회원가입
	@Override
	public void join(BedalUserVO vo) {
		mybatis.insert("bedal_user.join", vo);
	}

	// 아이디 중복검사
	@Override
	public int check_id(BedalUserVO vo) {
		int result = mybatis.selectOne("bedal_user.check_id", vo);
		return result;
	}
	
	// 로그인
	@Override
	public int login(BedalUserVO vo) {
		int result = mybatis.selectOne("bedal_user.login", vo);
		return result;
	}
	
	
	//배달 프로필 수정
	@Override
	public int bedal_profile(BedalUserVO vo) {
		int result = mybatis.update("bedal_user.update", vo);
		return result;
	}
}

