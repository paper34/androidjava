package com.trade.project.admin;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trade.project.user.UserVO;

@Repository
public class AdminUserDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	//admin 유저리스트
	public List<AdminUserVO> list(){
		List<AdminUserVO> list = mybatis.selectList("admin_user.userlist");
		return list;
	}
	
	//admin 유저한명검색
	public AdminUserVO one(AdminUserVO vo) {
		AdminUserVO vo2 =mybatis.selectOne("admin_user.userone", vo); 
		return vo2;
	}
	
	//admin 유저삭제
	public void delete(AdminUserVO vo) {
		mybatis.delete("admin_user.userdelete",vo);
		
	}
	
	

}
