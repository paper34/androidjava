package 영화예매배열;

import javax.swing.JOptionPane;

public class 신체검사 {

	public static void main(String[] args) {

		int go = 0, nogo = 0;
		int[] score = new int[3];
		// 입력
		for (int i = 0; i < 3; i++) {
			System.out.println("_____________________________________");
			String data = JOptionPane.showInputDialog("주민번호를 입력하시오");

			String data2 = JOptionPane.showInputDialog("키를 입력하시오");
			Double tall = Double.parseDouble(data2);

			String data3 = JOptionPane.showInputDialog("몸무게를 입력하시오");
			Double weight = Double.parseDouble(data3);

			String data4 = JOptionPane.showInputDialog("시력을 입력하시오");
			Double eye = Double.parseDouble(data4);

			String disease = JOptionPane.showInputDialog("병명을 입력하시오");

			System.out.println("주민번호: " + data);
			System.out.println("키: " + tall + "cm");
			System.out.println("몸무게: " + weight + "kg");
			System.out.println("시력: " + eye);
			System.out.println("병명은: " + disease);

//			// 현역, 면제 대상자 카운트
//			if (tall < 150 || tall > 190) {
//				nogo++;
//			} else if (weight / (tall * 0.01) * (tall * 0.01) > 30) {
//				nogo++;
//			} else if (eye < 0.0) {
//				nogo++;
//			} else {
//				go++;
//			}

			// 검사당 스코어 +
			for (int j = 0; j < 1; j++) {

				if (tall >= 150.0 && tall <= 190.0) {
					score[i] += 20; // 키 150~190 +20
				}
				if (weight >= 35 && weight <= 100) {
					score[i] += 20; // 몸무게 35~100 +20
				}
				if (eye == 1.0) {
					score[i] += 30; // 눈 1.0 +30
				}
				if (eye == 0.5) {
					score[i] += 20; // 눈 0.5 +20
				}
				if (eye == 0.1) {
					score[i] += 10; // 키 0.1 +20
				}
				if (score[i] >= 40) {
					go++;
					System.out.println();
					System.out.println("현역대상자 입니다");
				}
				if (score[i] < 40) {
					nogo++;
					System.out.println();
					System.out.println("면제대상자 입니다");
				}
				if (disease == "없음") {
					score[i] += 30;
				}
				if (disease == "평발") {
					score[i] += 20;
				}
				if (disease == "고혈압") {
					score[i] += 10;
				}
			}
			// 출력
			System.out.println();
			System.out.println("점수: " + score[i]);
			System.out.println();

		}
		System.out.println();
		System.out.println("현역대상자: " + go);
		System.out.println("면제 대상자: " + nogo);

	}

}
