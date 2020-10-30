package com.mega.mvc06;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class BbsDAO {

	@Autowired
	SqlSessionTemplate mybatis;

	public void insert() {
		mybatis.insert("bbs.create");
	}

	public void delete() {
		mybatis.delete("");
	}

	public void update() {
		mybatis.update("");
	}

	public BbsVO select() {
		BbsVO vo = mybatis.selectOne("");
		return vo;
	}

	public List<BbsVO> list() {
		List<BbsVO> list = mybatis.selectList("");
		return list;
	}

}
