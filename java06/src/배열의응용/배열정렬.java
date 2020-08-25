package 배열의응용;

import java.util.Arrays;

public class 배열정렬 {

	public static void main(String[] args) {
		int[] 나이 = { 99, 10, 100, 88, 33, 24, 10, 77 };
		// 배열 복사할때는 clone()함수 사용!
		// 깊은복사, 배열은 깊은복사를 해야한다.
		// 깊은 복사를 해야 배열은 따로 따로 만들어진다.
		
		int[] 나이2 = 나이.clone();
				
		Arrays.sort(나이); // 작 -> 큰 오름차순 정리
		// 파괴함수, 비파괴함수
		for (int y : 나이) {
			System.out.print(y + " ");
		}
		System.out.println("\n------------------");
		
		
		
		나이2[0] = 99;
		
		for (int x : 나이2) {
			System.err.println(x + "");
		}
	}

}
