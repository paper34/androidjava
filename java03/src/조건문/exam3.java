package 조건문;

import javax.swing.JOptionPane;

public class exam3 {

	public static void main(String[] args) {
		int iu = 0, u = 0, bts = 0;

		while (true) {
			String input1 = JOptionPane.showInputDialog("인기투표 1)아이유   2)유재석   3)방탄소년단   4)종료");
			int input = Integer.parseInt(input1);

			if (input == 4) {
				System.exit(0);
				
			} else if (input == 1) {
				System.out.println("아이유를 투표하셨습니다.");
				iu++;
				
			} else if (input == 2) {
				System.out.println("유재석을 투표하셨습니다.");
				u++;
				
			} else if (input == 3) {
				System.out.println("방탄소년단을 투표하셨습니다.");
				bts++;
			}
			
			System.out.println("아이유는 총: " + iu + "표 받앗습니다.");
			System.out.println("유재석은 총: " + u + "표 받앗습니다.");
			System.out.println("방탄소년단은 총: " + bts + "표 받앗습니다.");
			
		}
			
	}

}
