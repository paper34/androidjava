package com.trade.project.user;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trade.project.admin.AdminUserVO;

@Repository
public class UserDAO {

	@Autowired
	SqlSessionTemplate mybatis;

	// 회원가입
	public void join(UserVO vo) {
		mybatis.insert("user.join", vo);
	}

	// admin테이블 insert
		public void adminjoin(AdminUserVO vo) {
			mybatis.insert("user.admin_join",vo);
		}
	
	
	// 아이디 중복검사
	public int check_id(UserVO vo) {
		int result = mybatis.selectOne("user.check_id", vo);
		return result;
	}

	// 로그인
	public int login(UserVO vo) {
		int result = mybatis.selectOne("user.login", vo);
		return result;
	}

	// 찜
	public void zzim(ZzimVO vo) {
		mybatis.insert("user.zzim", vo);
	}

	// 찜 삭제
	public void zzim_delete(ZzimVO vo) {
		mybatis.delete("user.zzim_delete", vo);
	}

	// 찜 여부 확인
	public int zzim_check(ZzimVO vo) {
		int result = mybatis.selectOne("user.zzim_check", vo);
		return result;
	}

	// 찜 리스트 가져오기
	public List<ZzimVO> zzim_list(String user_id) {
		List<ZzimVO> list = mybatis.selectList("user.zzim_list", user_id);
		return list;
	}

	// 유저리뷰 리스트 가져오기
	public List<UserReviewVO> user_review(String user_id) {
		List<UserReviewVO> list = mybatis.selectList("user.user_review", user_id);
		return list;
	}

}
