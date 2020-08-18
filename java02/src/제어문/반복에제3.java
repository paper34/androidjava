package 제어문;

public class 반복에제3 {

	public static void main(String[] args) {
		int start = 1; // 시작값
		int end = 100; // 종료값
		int add = 2; // 증가값
		while (start < end) { // 조건: 시작값(1) < 종료값(100)
			System.out.println(start); // 시작값을 출력
			start = start + add; // 시작값 = 시작값(1) + 증가값(2) ... false까지 반복
		}

	}
}