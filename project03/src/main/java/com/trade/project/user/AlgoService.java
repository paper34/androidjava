package com.trade.project.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlgoService {
	
	@Autowired
	AlgoDAO dao;
	
	public List<AlgoVO> algolist(AlgoVO vo) {
		return dao.algolist(vo);
	}
}
