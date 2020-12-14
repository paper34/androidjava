package com.trade.project.algolism.qa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.project.admin.AdminQuestionVO;

@Service
public class AlgolismQaService {

	@Autowired
	AlgolismQaDAO dao;

	@Autowired
	Algolism al;

	public List<AlgolismVO> list_age(String user_id) {

		List<AlgolismVO> list = dao.list_age(user_id); // dao에서 가져온 list

		double[][] score = new double[list.size()][2];// 이차원점수배열
		byte age_score = 0; // 세대별 점수 100점
		int count_score = 0; // 조회수 max = 1000개 ==>1000점 만점
		double final_score = 0.0; // 최종 점수
		double num = 0.0; // 점수 추출

		for (int i = 0; i < list.size(); i++) {
			
			age_score = al.agenum((byte) list.get(i).getUser_age(), (byte) list.get(i).getQa_age()); // 세대별점수
			count_score = al.qa_count(list.get(i).getQa_count()); // 조회수
			num = al.final_score(count_score, age_score);// 거리 계산
			final_score = Math.round(num * 100) / 100.0; // 소수점 2자리까지 반환
			score[i][0] = list.get(i).getQa_no(); // 게시물 번호 뽑기
			score[i][1] = final_score; // 최종 점수
			System.out.println(score[i][0] + " : " + score[i][1]);
		}

		QuickSort.quickSort(score, 0, list.size() - 1);// 가져온 점수 퀵솔트 내림차순(스태틱)
		System.out.println(score[0][0] + " : " + score[0][1]);

		List<AlgolismVO> list2 = new ArrayList<AlgolismVO>() ; // 퀵솔트용 list
		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++) { 
			for (int j = 0; j < list.size(); j++) {
				if (score[i][0] == list.get(j).getQa_no()) {
					list2.add(list.get(j)); //퀵솔트한 데이터들을 새로운 list2에 담기위해 분기처리
					break;
				}
			}
		}

		return list2;
	}
	
	public AlgolismVO one(AlgolismVO vo) {
		return dao.one(vo);
	}
}
