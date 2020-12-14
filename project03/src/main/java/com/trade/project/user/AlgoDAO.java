package com.trade.project.user;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AlgoDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	// x축, y축, swap, QuickSort 담겨있는 class 
	@Autowired
	Algo algo;
	
	public List<AlgoVO> algolist(AlgoVO vo) {
		 List<AlgoVO> list = mybatis.selectList("user.algolist", vo);
		 
		 // 정렬이 안되어있는 list의 값을 담고 빼기위해 이중배열 선언
		 int[][] a = new int[list.size()][2];
		 
		 
		 for (int j = 0; j < list.size(); j++) {
			 
			 a[j][0] = j; 
					 
			 a[j][1] = (int)age(list.get(j));
			 
		}
		 
		 //점수순으로 정렬
		 algo.QuickSort(a, 0, list.size()-1);
		 
		 // 퀵솔트가 완료된 a배열을 새로운 List에 담아 컨트롤러에 전달해주기위해서 새로 선언
		 List<AlgoVO> list2 = list;
		 
		 
		 for (int i = 0; i < list2.size(); i++) {
			 list2.set(i, list.get(a[i][0]));
		}
		 
		 return list2;
	}
	
	// DB연결 - 각 가격점수, 나이점수 구하는 메소드
	public double age(AlgoVO vo) {
		//       가격, 나이 등 VO를 담고있는 List
		List<AlgoVO> id_age = mybatis.selectList("user.age", vo);
		
		//  나이대의 총합을 구하기 위해 지역변수 초기화
		int age_sum = 0;
		
		// 1. 리스트에서 유저의 나이대를 가져온다
		for (int i = 0; i < id_age.size(); i++) {
			
			// 2. 나이대를 다 더한다.
			age_sum += (id_age.get(i).getUser_age());
			
		}
		
		// 평균 (product_age) = 총합 / 사람수  
		int age_avg = age_sum / id_age.size();
		
		byte ageScore = algo.point2((byte)vo.getUser_age(), (byte)age_avg); // 나이 점수구하기 
		int priceScore = algo.point(vo.getProduct_price()); // 가격점수구하기 
		
		//  총  x,y축 점수 구한후  원점에서 거리 결과  
		double result = algo.sum(priceScore, ageScore);
		
		// 거리결과 반환
		return result;
		
		
	}
	
	
	
}
