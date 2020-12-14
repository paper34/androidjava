package com.trade.project.admin;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminReportDAO {

	@Autowired
	SqlSessionTemplate mybatis;

	// admin report 리스트
	public List<AdminReportVO> list() {
		List<AdminReportVO> list = mybatis.selectList("admin_report.reportlist");
		return list;
	}

	// admin report 디테일
	public AdminReportVO one(AdminReportVO vo) {
		AdminReportVO one = mybatis.selectOne("admin_report.reportdetail", vo);
		return one;
	}

	// admin report 유저블랙
	public void update(AdminReportVO vo) {
		mybatis.delete("admin_report.userreport", vo);
	}
	
	// admin report 유저블랙
	public void update2(AdminReportVO vo) {
		mybatis.delete("admin_report.userrelease", vo);
		}

}
