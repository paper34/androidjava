package 배열의응용;

import javax.swing.JOptionPane;

public class 예제 {

	public static void main(String[] args) {
		// 문제1
		int[] num = { 10, 20, 30, 40, 50 };
		int sum = num[0] + num[1];

		System.out.println(sum);

		// 문제2
		String data = null;
		for (int i = 0; i < 3; i++) {
			data = JOptionPane.showInputDialog("JAVA, SPRING, JSP중 입력하시오"); 
			System.out.println("과목 입력: " + data);
		}

		// 문제3
		int[] nm = { 11, 22, 33, 44 };
		int target = 33;
		for (int x : nm) {
			System.out.println(x);
		}
		for (int j = 0; j < nm.length; j++) {
			if (nm[j] == target) {
			System.out.println(target + "의 위치: " + j);
			}
		}

		// 문제4
		String num1 = null;
		for (int i = 0; i < 5; i++) {
			num1 = JOptionPane.showInputDialog("숫자 1~5까지 입력하시오");
			int n1 = Integer.parseInt(num1);
			System.out.print(n1 + " ");
			
		}
		
		// 문제5
		int[] sum1 = { 66, 77, 88, 99};
		int max = sum1[0];
		
		for (int i = 0; i < sum1.length; i++) {
			if (sum1[i] > max) {
				max = sum1[i];
			}
		}
		System.out.println("최대값은: " + max);
		
		// 문제6
		int[] num6 = {66, 77, 88, 99};
		int imsi = num6[0]; //imsi <- 66
		num6[0] = num6[3]; // nmu6[0] <- 99
		num6[3] = imsi; // num6[3] <- imsi
		
		for (int x : num6) {
			System.out.println(x + " ");
		}
		System.out.println();

	}
}
