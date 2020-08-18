package 제어문;

import javax.swing.JOptionPane;

public class 조건문예제1 {

	public static void main(String[] args) {
		// 입력
		String food = JOptionPane.showInputDialog("먹고싶은 후식 음식은?");

		// 처리
		String result = "";
		if (food.equals("아이스크림")) {
			result = "뚜레주르로 가요";
		} else if (food.equals("아이스크커피")) {
			result = "이디야로 가요";
		} else {
			result = "물먹요";
		}

		// 출력
		System.out.println(result);
	}

}
