package 연산자;

import javax.swing.JOptionPane;

public class 기본입출력2 {

	public static void main(String[] args) {
		String num1 = JOptionPane.showInputDialog("숫자를 입력하시오");
		int n1 = Integer.parseInt(num1);
		// ctrl + alt + 화살표아래: 한줄복사
		// alt + 화살표방향: 이동
		String num2 = JOptionPane.showInputDialog("숫자를 입력하시오");
		int n2 = Integer.parseInt(num2);

		int res = n1 + n2;

		System.out.println("두 숫자의 합은=" + res);

	}

}
