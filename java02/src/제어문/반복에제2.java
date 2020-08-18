package 제어문;

public class 반복에제2 {

	public static void main(String[] args) {
		int start= 5; //시작값
		int end = 10; //종료값
		//int plus = 1; //증가값
		while (start <= end) { //조건: 시작값(5) <= 종료값(10)
			System.out.println(start); //시작값을 출력
			//start = start + plus; //시작값 = 시작값(5) + 증가값(1) ... false까지 반복
			
			start++;//증감연산자 +1
	}

}
}