package 조건문;

public class 성별판별2 {

	public static void main(String[] args) {
		String com = "A100EX";

		char com1 = com.charAt(0);

		switch (com1) {
		case 'A':
			System.out.println("기획부");
			break;
		case 'B':
			System.out.println("총무부");
			break;
		case 'C':
			System.out.println("개발부");
			break;

		default:
			System.out.println("해당부서없음");
			break;
		}
		String sub = com.substring(1, 4); // 문자 1~ 이상 문자추출
		// 인덱스 1~3 범위 추출이면 substring(1,4)써줌
		// endIndex는 3보다 1큰 4를 써주어야함.
		System.out.println("사원고유번호는" + sub);
	}

}
