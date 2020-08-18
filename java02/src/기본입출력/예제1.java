package 기본입출력;

import javax.swing.JOptionPane;

public class 예제1 {

	public static void main(String[] args) {
		// 데이터: 입력
		String num1 = JOptionPane.showInputDialog("숫자를입력하시오1");
		int n1 = Integer.parseInt(num1);
		// 2. 처리
		String num2 = JOptionPane.showInputDialog("숫자를입력하시오2");
		int n2 = Integer.parseInt(num2);

		// 3. 결과: 출력
		System.out.println("두수의 합은=" + (n1 + n2));
		System.out.println("두수의 뺏셈은=" + (n1 - n2));
		System.out.println("두수의 곱은=" + (n1 * n2));
		System.out.println("두수의 나눗셈은=" + (n1 / n2));

	}

}
