package 조건문;

import javax.swing.JOptionPane;

public class exam {

	public static void main(String[] args) {

		// 변수
		int target = 88; // 점수 88점 선언
		int ok = 0, no = 0; // 횟수 선언

		// 반복
		while (true) {
			String data = JOptionPane.showInputDialog("숫자를 입력해보세요"); // 숫자 입력
			int res = Integer.parseInt(data);// 입력받은 걸 정수로 변환

			if (res == target) {
				System.out.println("정답입니다.축하합니다!");
				ok++; // 맞춘회수 타이머

				System.out.println("시도 횟수: " + ok + "회");
				System.out.println("틀린 횟수: " + no + "회");
				break; // 정답을 맞추면 break 정지

			} else if (res > target) {
				System.out.println("정답보다 큽니다!");
				no++; // 틀린횟수 타이머

			} else if (res < target) {
				System.out.println("정답보다 작습니다!");
				no++;// 틀린횟수 타이머
			}

			// 출력
			System.out.println("틀린 횟수: " + no + "회"); // 결과적으로 틀린횟수 출력
		}

	}

}
