package com.trade.project.bedal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BedalUserService {
	
	@Autowired
	BedalUserInterface dao;
	
	//회원가입
	public void join(BedalUserVO vo) {
		dao.join(vo);
	}
	
	// 아이디 중복체크
	public int check_id(BedalUserVO vo) {
		int result =  dao.check_id(vo);
		return result;
	}
	
	// 로그인
	public int login(BedalUserVO vo) {
		int result = dao.login(vo);
		return result;
	}
	
	
	// 프로필 수정
	public int bedal_profile(BedalUserVO vo) {
		int result = dao.bedal_profile(vo);
		return result;
	}
	
}
