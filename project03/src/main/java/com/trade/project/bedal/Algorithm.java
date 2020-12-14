package com.trade.project.bedal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class Algorithm {

	@Autowired
	SqlSessionTemplate mybatis;
	// 오랜된 것 중에 거래가격이 높은거
	// 거래가격이 높은 순으로 찾자!

	
	// 배달 추천 목록
	public List<BedalListVO> algolist(String bedal_id) throws ParseException { 
			//<>안에 object 들어감
			//원시자료 안됨(ex. int 안됨)
			//원시자료 wrapperClass(포장클래스)- 부모x,객체 아님(true,false, ..등등)
			
			List<BedalListVO> algolist = mybatis.selectList("bedal_list.algolist", bedal_id);
			
			Algorithm a1 = new Algorithm();
			
			double[][] z = new double[algolist.size()][2];
			for (int i = 0; i < algolist.size(); i++) {
				System.out.println(algolist.get(i).getPayment_id());
				int price = a1.p_score(Integer.parseInt(algolist.get(i).getPayment_price()));
				float date = a1.d_score(algolist.get(i).getPayment_date());
				double num = a1.f_score(price, date);
				double score = Math.round(num * 100) / 100.0;
				
				z[i][0] = algolist.get(i).getPayment_id();
				z[i][1] = score;
				System.out.println(" ::: " + z[i][0] + "::" + z[i][1]);
			}
			
			//점수 순으로 정렬
			a1.QuickSort(z, 0, algolist.size()-1);
			
			for (int i = 0; i < z.length; i++) {
				System.out.println(z[i][0] + " ::: " + z[i][1]);
			}
			
			//리스트 초기화
			List<BedalListVO> algolist2 = new ArrayList<>();
			
			
			for (int i = 0; i < z.length; i++) {
				//id같은 거를 뽑기, id값이랑 인덱스 같음 -> 이중for문
				//같은 vo 리스트의 이중 포문 첨부터 끝까지 아이디 같은게 있으면 반환할 리스트의 첫 번째
				for (int j = 0; j < z.length; j++) {
					if(z[i][0] == (double) algolist.get(j).getPayment_id()) {
						System.out.println(algolist.get(j).getPayment_id());
						algolist2.add(algolist.get(j));
						break;
						
					}
				}
			}
			
			
			return algolist2;
		}
	
		


	// 현재날짜
	DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date nowDate = new Date();

	String date1 = sdFormat.format(nowDate);
	String date2;

//date2에 값을 넣기
//date2 <- 상품의 결제 날짜
//for문으로 값 넣기
//이차원배열(id, 점수)
//점수로 퀵솔트 정렬

	public float d_score(String date2) throws ParseException {// y축
		// 세션에 있는 id 가져오면 실행되게
		// dao 선언도 해야함

		// 상품 정보: price, date 가져오기
		// 메서드 안에서는 초기화 안됨
		this.date2 = date2;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date FirstDate = format.parse(date1);
		Date SecondDate = format.parse(date2);
		float calDate = FirstDate.getTime() - SecondDate.getTime();
		float calDateDays = calDate / (24 * 60 * 60 * 1000);

		float s_y = calDateDays / 4; // 913점 만점

		return s_y;
	}

	public int p_score(int p) { // 100점 만점,x축

		int score = p / 10000;

		if (p > 1000000) {
			score = 100;
		}
		return score;
	}

	public double f_score(int x, float y) {// 최종 점수 (final score)

		double cal1 = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));//거리계산
		// p의 제곱 + s_y제곱 의 루트
		// Math.pow(a, 2) -> a의 제곱
		// Math.sqrt(a) -> a의 루트

		return cal1;

	}
	
	public void swap(double[][] z, int idx1, int idx2) {
		double[] t = {z[idx1][0],z[idx1][1]}; 
		z[idx1][0] = z[idx2][0];
		z[idx1][1] = z[idx2][1];
		z[idx2][0] = t[0];
		z[idx2][1] = t[1];
	}
	
	public void QuickSort(double[][] z, int l, int r) {
		int pl = l;
		int pr = r;
		double x = z[(pl + pr) / 2][1];
		
		do {
			while(z[pl][1] > x) pl++;
			while(z[pr][1] < x) pr--;
			if(pl <= pr) swap(z, pl++, pr--);
		}while(pl <= pr);
		
		if(l < pr) QuickSort(z, l, pr);
		if(pl < r) QuickSort(z, pl, r);
	}


}

