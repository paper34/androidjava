package com.mega.mvc06;

public class BbsService {

	BbsDAO dao; // 전역 변수

	// 전역변수의 주소/ 값를 넣는 방법은
	// 1. 파라메터 있는 생성자를 사용해라.
	// 2. set메서드를 만들어라.

	/*
	 * public BbsService(BbsDAO dao) { this.dao = dao; }
	 */

	public void setDao(BbsDAO dao) {
		this.dao = dao;
	}

}
