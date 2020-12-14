package com.trade.project.algolism.qa;

import org.springframework.stereotype.Service;

@Service
public class Algolism {

	public byte agenum(byte input_age, byte qa_age) { // y축

		byte y_input_minusage = (byte) (input_age + 140);
		byte y_input_plusage = (byte) (60 - input_age);
		byte age_score = 0;
		if (input_age <= qa_age) {
			age_score = (byte) (-3 * (qa_age) + y_input_minusage);
		} else {
			age_score = (byte) (3 * (qa_age) + y_input_plusage);
		}
		return age_score; // 세대별 점수
	}

	public int qa_count(int max_qcount) { // 조회수최대 : max_qcount = 1000; x축
		max_qcount = max_qcount / 100;
		int count_score = max_qcount * 10; // 점수 : 100점 만점
		return count_score;
	}
	
	public double final_score(int y, byte x) {// 최종 점수 (final score)
		double f_score = Math.pow((x * y) + (x * y), 0.5);// 거리계산
		return f_score;
	}

}
