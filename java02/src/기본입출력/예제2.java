package 기본입출력;

import javax.swing.JOptionPane;

public class 예제2 {

	public static void main(String[] args) {
		String num1 = JOptionPane.showInputDialog("숫자를 입력하시오(시작값)");
		int n1 = Integer.parseInt(num1);
		
		String num2 = JOptionPane.showInputDialog("숫자를 입력하시오(종료값)");
		int n2 = Integer.parseInt(num2);
		
		int start = n1;
		int stop = n2;
		
		while (start<=stop) {
			System.out.println(start);
			start++;
		}
	}

}
