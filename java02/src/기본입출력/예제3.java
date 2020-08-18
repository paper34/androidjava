package 기본입출력;

import javax.swing.JOptionPane;

public class 예제3 {

	public static void main(String[] args) {

		String num1 = JOptionPane.showInputDialog("숫자를 입력하시오"); // 입력
		int n1 = Integer.parseInt(num1); // 변환

		String do1 = JOptionPane.showInputDialog("문자를 입력하시오"); // 입력

		for (int i = 0; i < n1; i++) { // 출력
			System.out.println(do1 + " ");
		}
	}

}
