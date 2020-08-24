package 배열응용;

import java.util.Random;

public class 입력해서넣어보자5 {

	public static void main(String[] args) {

		Random r = new Random();

		int[] data = new int[100];

		for (int i = 0; i < 100; i++) {

			data[i] = r.nextInt(100);
		}
		
		
		for (int x : data) {
			System.out.println(x);
			
			
		}
		
		System.out.println(data[0] + data[99]);
	}

}
