package 시험;

import javax.swing.JOptionPane;

public class 문제1 {

	public static void main(String[] args) {
		// 입력값 배열 저장
		String[] name = new String[5]; // 이름 배열 5개
		int[] money = new int[5]; // 금액 배열 5개
		int sum = 0; //총합
		int res = 0; // 평균
		
		// 반복
		while (true) {
			String m = JOptionPane.showInputDialog("1)입력 2)출력 3)수정 4)정리 5)종료");
			//1번 선택
			if (m.equals("1")) {
				// 예금자명 , 입금액  반복문을 통해 5번 입력 후 배열 저장
				for (int i = 0; i < 5; i++) {
					name[i] = JOptionPane.showInputDialog("예금자명을 입력하세오");
					String in = JOptionPane.showInputDialog("예금액 입력하세요");
					int in2 = Integer.parseInt(in);
					money[i] = in2;
				}

			}
			//2번 선택
			if (m.equals("2")) {
				// 배열에 저장된 입력값을 출력
				for (int i = 0; i < 5; i++) {
					System.out.println("입급자명: " + name[i] + "예금액: " + money[i]);
				}

			}
			//3번 선택
			if (m.equals("3")) {
				if (name[0].equals("박창호")) {
					money[0] = 100;
					System.out.println("첫 예금자명: " + name[0] + " " +  "첫번째 예금액: " + money[0]);
				} else {
					System.out.println("예금자와 동일하지 않습니다.");
				}
			}
			//4번 선택
			if (m.equals("4")) {
				for (int i = 0; i < 5; i++) {
					sum = sum + money[i]; // 총합 = 총합 + 금액
					res = sum / 5;  // 평균 = 총합/5 
				}
				System.out.println("합: " + sum + "원" +  " "+ "평균" + res + "원");
			}
			//5번 선택
			if (m.equals("5")) {
				System.out.println("끝 byebye");
				break;
			}
		}

	}

}
