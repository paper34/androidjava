package 연산자;

import javax.swing.JOptionPane;

public class 논리연산자3 {

	public static void main(String[] args) {
		String 가입id = "root";
		String 가입pw = "pass";

		String 로그인id = JOptionPane.showInputDialog("아이디입력");
		String 로그인pw = JOptionPane.showInputDialog("패스워드입력");
		
		
		if (가입id.equals(로그인id) && 가입pw.equals(로그인pw)) {
			System.out.println("로그인ok");
		} else {
			System.out.println("로그인 not");
		}
	}

}
