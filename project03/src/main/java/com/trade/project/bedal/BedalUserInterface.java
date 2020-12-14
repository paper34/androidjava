package com.trade.project.bedal;

public interface BedalUserInterface {

	// 회원가입
	void join(BedalUserVO vo);

	// 아이디 중복검사
	int check_id(BedalUserVO vo);

	// 로그인
	int login(BedalUserVO vo);

	//배달 프로필 수정
	int bedal_profile(BedalUserVO vo);

}