package 반복문;

public class 연습문제4 {

	public static void main(String[] args) {
		// 이중for문  , 문제 3번
		for (int i = 2; i < 10; i++) { // 구구단 -단
			for (int j = 1; j < 10; j++) { // 곱하는 수
				if (i < j) {
					break;
				}
				System.out.println(i + "*" + j + "=" + i * j); // 출력

			}

		}

	}

}	
