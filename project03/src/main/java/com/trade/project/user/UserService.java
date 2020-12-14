package com.trade.project.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.project.admin.AdminUserVO;

@Service
public class UserService {

	@Autowired
	UserDAO dao;

	// 회원가입
	public void join(UserVO vo) {
		dao.join(vo);
	}

	// admin테이블 insert
		public void adminjoin(AdminUserVO vo) {
			dao.adminjoin(vo);
		}
		
		
	// 회원가입-아이디 중복체크
	public int check_id(UserVO vo) {
		int result = dao.check_id(vo);
		return result;
	}

	// 로그인
	public int login(UserVO vo) {
		int result = dao.login(vo);
		return result;
	}

	// 찜하기(insert)
	public void zzim(ZzimVO vo) {
		dao.zzim(vo);
	}

	// 찜 삭제 (delete)
	public void zzim_delete(ZzimVO vo) {
		dao.zzim_delete(vo);
	}

	// 유저가 찜을 했는지 확인 (status)
	public int zzim_check(ZzimVO vo) {
		int result = dao.zzim_check(vo);
		return result;
	}

	// 유저 찜 목록 (zzim_list)
	public List<ZzimVO> zzim_list(String user_id) {
		return dao.zzim_list(user_id);
	}

	// 유저 매너평가 목록 (review_list)
	public List<UserReviewVO> user_review(String user_id) {
		return dao.user_review(user_id);
	}

}
