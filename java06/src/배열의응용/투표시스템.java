package 배열의응용;

import javax.swing.JOptionPane;

public class 투표시스템 {

	public static void main(String[] args) {

		System.out.println("=====투표시스템=====");

		// 배열 선언
		String[] names = { "블랙핑크", "유재석", "아이유", "이효리", "비" };
		int[] 투표수 = { 0, 0, 0, 0, 0 };

		// 입력
		for (int i = 0; i < 10; i++) {
			String choice = JOptionPane.showInputDialog("0)블랙핑크 , 1)유재석, 2)아이유, 3)이효리 , 4)비  중에 숫자를 입력하시오");
			int cho = Integer.parseInt(choice);
			// 0 ~ 4

			투표수[cho]++;

		}
		// 표수 출력
		for (int i = 0; i < 투표수.length; i++) {
			System.out.println(names[i] + "는 " + 투표수[i] + "표");
		}

		// 최대투표2
		int max = 투표수[0];
		for (int i = 0; i < 투표수.length; i++) {
			if (투표수[i] > max) {
				max = 투표수[i];
			}

		}
		System.out.println("최대값은: " + max);
		// 최대 투표수, 이름
		for (int i = 0; i < 투표수.length; i++) {
			if (투표수[i] == max) {
				System.out.println(i + ": " + names[i]);
			}
		}

	}

}
