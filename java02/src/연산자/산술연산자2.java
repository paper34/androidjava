package 연산자;

public class 산술연산자2 {

	public static void main(String[] args) {
		int x = 200;
		int y = 100;
		// 더해봅시다.
		int sum = x + y;
		// 자바에서는 int끼리의 계산은 무조건 int!
		double div = y/x;
		// 8바이트 double <- 4바이트 int
		System.out.println("두 수의 합은"+sum);
		System.out.println("두 수의 나눗셈은"+div);
		// 자바에서는 하나라도 double이면 무조건  double!
		// 하나만 정수를 실수록 강제로 전환해서 계산시 사용할 수 있다.
		double div2 = (double)y /x;
		System.out.println("두 수의 나눗셈은2"+div2);
		
		double div3 = (double)(y /x);
		System.out.println("두 수의 나눗셈은2"+div3);
	}

}
