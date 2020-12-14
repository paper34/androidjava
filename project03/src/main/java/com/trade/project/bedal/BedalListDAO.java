package com.trade.project.bedal;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

import javax.servlet.http.HttpSession;


@Repository
public class BedalListDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;

	
	// 배달내역 뽑아오기(정후)
	public List<BedalListVO> list() {
		List<BedalListVO> list = mybatis.selectList("bedal_list.list");
		return list;
	}

	// 배달내역 상세(정후)
	public BedalListVO one(BedalListVO vo) {
		BedalListVO vo2 = mybatis.selectOne("bedal_list.one", vo);
		return vo2;
	}

	// 배달 상태 거절 업데이트(정후)
	public void update(BedalListVO vo) {
		mybatis.update("bedal_list.reject_update", vo);
	}

	// 배달 상태 수락 업데이트(정후)
	public void acceptupdate(BedalListVO vo) {
		mybatis.update("bedal_list.accept_update", vo);
	}

	// 배달 상태 완료 업데이트(정후)
	public void update3(BedalListVO vo) {
		mybatis.update("bedal_list.done_update", vo);
	}

	
	

	//배달상태 수정, 아이디 저장(혜정)
	public void update(BedalOriginListVO vo) {
		mybatis.update("bedal_origin_list.update", vo);
	}
	

	//배달 승인내역(혜정)
	public List<BedalListVO> approval(String bedal_id) {
		List<BedalListVO> approval = mybatis.selectList("bedal_list.approval", bedal_id);
		return approval;
	}
	
	//최근 본 배달내역(혜정)
	public List<BedalListVO> bedal_lately(List<String> list1) {
		List<BedalListVO> list = null;
		for (int i = 0; i < list1.size(); i++) {
			list.add(mybatis.selectOne("bedal_list.lately", list1.get(i)));	
		}		
		return list;
	}
	
	
}