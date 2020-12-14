package com.trade.project.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.project.user.UserVO;


@Service
public class AdminUserService {
	
	@Autowired
	AdminUserDAO dao;
	
	public List<AdminUserVO> list(){
		return dao.list();	
	}
	
	public AdminUserVO one(AdminUserVO vo) {
		return dao.one(vo);
	}
	
	public void delete(AdminUserVO vo) {
		dao.delete(vo);
	
	}
	

}
