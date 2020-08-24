package 배열응용;

import java.util.Random;

public class 답안지 {

	public static void main(String[] args) {
		Random r = new Random(); // 아무값
		int[] result = new int[1000];
		int[] my = new int[1000];

		int count = 0;

		for (int i = 0; i < my.length; i++) {
			result[i] = r.nextInt(4);
			my[i] = r.nextInt(4);
		}
		
		System.out.println("문항\t정답지\t내답\t처리");
		
		for (int i = 0; i < my.length; i++) {
			String res = "오답";
			if (result[i] == my[i]) {
				res = "정답";
				count++;
			}
			System.out.println(i + "\t" + result[i] + "\t" + my[i] + "\t" + res);
		}
		System.out.println("점수: " + count);

	}

}
