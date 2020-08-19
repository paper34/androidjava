package 조건문;

import javax.swing.JOptionPane;

public class exam2 {

	public static void main(String[] args) {

		int money = 0; // 남은금액

		while (true) {
			// 입력
			String input = JOptionPane.showInputDialog("1)입금  2)출금  3)잔고  4)종료");
			int input1 = Integer.parseInt(input);

			// 입금
			if (input1 == 1) {
				String inmoney = JOptionPane.showInputDialog("입금할 금액을 입력하시오.");
				int inmoney1 = Integer.parseInt(inmoney); // 입력받은 돈 정수변환
				money = inmoney1 + money; // 남은금액 = 입금금액-남은금액
				JOptionPane.showMessageDialog(null, "입금하신 금액은: " + money + "입니다.");

				// 출금
			} else if (input1 == 2) {
				String outmoney = JOptionPane.showInputDialog("출금할 금액을 입력하시오.");
				int outmoney2 = Integer.parseInt(outmoney);
				money = money - outmoney2; // 남은금액 = 남은금액 - 출금금액
				JOptionPane.showMessageDialog(null, "출금하신 금액은: " + outmoney2 + "입니다.");
				JOptionPane.showMessageDialog(null, "남으신 금액은: " + money + "입니다.");

				// 잔고
			} else if (input1 == 3) {
				JOptionPane.showMessageDialog(null, money);
				// 종료
			} else if (input1 == 4) {
				JOptionPane.showMessageDialog(null, "종료합니다");
				System.exit(0);
			}

		}
	}
}
