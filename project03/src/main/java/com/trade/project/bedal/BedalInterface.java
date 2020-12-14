package com.trade.project.bedal;

import java.util.List;

public interface BedalInterface {

	BedalListVO mailSend2(BedalListVO vo) throws Exception;

	//정후
	List<BedalListVO> list();

	//정후
	BedalListVO one(BedalListVO vo);

	//정후
	void update(BedalListVO vo);

	//정후
	void acceptupdate(BedalListVO vo);

	//정후
	void update3(BedalListVO vo);
}
