package 배열의응용;

import java.util.Random;

public class 원하는값찾기 {

	public static void main(String[] args) {
		Random r = new Random(); // 랜덤 같은값 42
		int[] number = new int[100];

		// 숫자 랜덤생성
		for (int i = 0; i < number.length; i++) {
			number[i] = r.nextInt(1000)-444; // 0~999   + 양수 - 음수
		}

		int max = number[0];
		int min = number[0]; // 꼭!! 값을 생성하고 최소값을 정의

		// i번째 랜덤숫자 추출
		for (int i = 0; i < number.length; i++) {
			System.out.println(i + ": " + number[i]);

		}

		// 최대 max값 , min값
		for (int i = 0; i < number.length; i++) {
			if (number[i] > max) {
				max = number[i];
			}
			if (number[i] < min) {
				min = number[i];
			}
		}
		System.out.println("max값: " + max);
		System.out.println("min값: " + min);

		// 최대값 개수 and 위치
		int count = 0;
		for (int i = 0; i < number.length; i++) {
			if (number[i] == max) {
				System.out.println(max + "의 위치는: " + i);
				count++;
			}
		}
		System.out.println(max + "의 개수는" + count);

//		int target = 884;
//		int count = 0;
//		for (int i = 0; i < number.length; i++) {
//			if (number[i] == target) {
//				System.out.println(target + "의 위치는" + i);
//
//				count++; // 증감연산자
//			}
//		}
//		System.out.println(target + "의 개수는 " + count + "개");

	}

}
