package 반복문;

import javax.swing.JOptionPane;

public class 연습문제1 {

	public static void main(String[] args) {
		// 입력
		String num = JOptionPane.showInputDialog("숫자를 입력하시오");
		String oper = JOptionPane.showInputDialog("+, -, *, / 를 입력하시오 ");
		String num1 = JOptionPane.showInputDialog("숫자를 입력하시오");

		// 변환
		int nm = Integer.parseInt(num);
		char or = oper.charAt(0);
		int nm1 = Integer.parseInt(num1);

		switch (or) {
		case '+':
			System.out.println(nm + nm1);
			break;
		case '-':
			System.out.println(nm - nm1);
			break;
		case '*':
			System.out.println(nm * nm1);
			break;
		case '/':
			System.out.println(nm / nm1);
			break;

		default:
			break;
		}

	}

}
