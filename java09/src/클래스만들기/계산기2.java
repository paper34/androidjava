package 클래스만들기;

public class 계산기2 {
	// 각 부품의 기능을 정의할 때는 메서드를 쓴다.
	// 메서드의 입력값 잠깐 저장할 용도로 선언된 변수
	// 메서드의 사용과 처리의 중간 다리역할 변수: 매개변수(parameter, 파라메터)

	public void add(int x, int y) { // void == 없다.
		// x, y변수는 add메서드 지역에서만 쓸 수 있는 지역변수
		// local 변수, 로컬변수
		// 지역변수는 자동초기화 되지 않음
		int result = x + y;
		System.out.println("합은: " + result);
	}

	public void minus() {
		System.out.println("빼기 기능");
	}

	public int mul(int x, int y) { 
		int result = x * y;  //return 이랑 void랑 같이 못씀, 보내는 타입을 써야함
		return result; // 30000
	}

	public void div() {
		System.out.println("나누기 기능");
	}
}
