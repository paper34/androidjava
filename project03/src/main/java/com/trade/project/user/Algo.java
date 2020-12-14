package com.trade.project.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Algo {
	

	@Autowired
	SqlSessionTemplate mybatis;
	
	
	public int point(int money) { // x축

		int calmoney = (money / 1000);  // 가격점수 = 상품가격 / 1000

		if (money > 100000) { // 상품가격이 십만원이 넘으면
			
			calmoney = 100; // 가격점수는 100점
			
		}

		return calmoney; // 가격 점수 반환

	}

	//                  세션 잡힌 유저나이     상품을 등록한 유저의 나이
	public byte point2(byte input_age, byte product_age) { //y축

		int y = (input_age + 100); // y = 세션잡힌 ID 유저의 나이 + 100

		int y2 = (100 - input_age); // y2 = 100 - 세션잡힌 ID 유저의 나이

		byte score = 0; // 지역변수 : 나이점수 초기화

		if (input_age <= product_age) {

			score = (byte) (-1 * (product_age) + y);

		} else {

			score = (byte) (1 * (product_age) + y2);
		}

		return score; // 나이점수 반환

	}

	//               가격점수     나이점수
	public double sum(int x, byte y) {
		//  최종점수      =      루트    가격점수(x) 2제곱  +  나이점수(y) 2제곱  
		double result = Math.sqrt( Math.pow(x, 2) + Math.pow(y, 2));
		
		// 최종점수 반환
		return result;
		
	}
	// swap                       
	public void swap(int[][] a, int idx1, int idx2) {
		int[] t = {a[idx1][0], a[idx1][1]}; 
		a[idx1][0] = a[idx2][0];
		a[idx1][1] = a[idx2][1];
		a[idx2][0] = t[0];
		a[idx2][1] = t[1];
		
	}
	
	public void QuickSort(int[][] a, int l, int r) {
		int pl = l;
		int pr = r;
		int x = a[(pl + pr) / 2][1];
		
		do {
			
			while(a[pl][1] < x) pl++;
			while(a[pr][1] > x) pr--;
			if(pl <= pr) swap(a, pl++, pr--);
			
		}while(pl <= pr);
		
		if(l < pr) QuickSort(a, l, pr);
		if(pl < r) QuickSort(a, pl, r);
	}
	
	

}
