package 제어문;

public class 반복문2 {

	public static void main(String[] args) {
		// 정해진 횟수만큼 반복해보자.
		int start = 1; //시작값
		int end = 5; //종료값
		//int add = 1; //증가값
		
		while (start <= end) { //시작값(1) <= 종료값(5)
			System.out.println(start); // 시작값(start) 출력
			//start = start + add; // 시작값 = 시작값(1) + 증가값(1) ...
			start++;
		}
		

	}

}
