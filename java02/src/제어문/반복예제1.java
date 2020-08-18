package 제어문;

public class 반복예제1 {

	public static void main(String[] args) {
		int start = 100; // 시작값
		int end = 1; // 종료값
		//int minus = 1; // 빼기값
		while (start >= end) { // 조건: 시작값(100) >= 종료값(1)
			System.out.println(start); // 시작값을 출력
			//start = start - minus; // 시작값 = 시작값(100) - 빼기값(1) ... false까지 반복
			start--;
		}
	}

}
