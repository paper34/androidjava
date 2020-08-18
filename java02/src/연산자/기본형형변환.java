package 연산자;

public class 기본형형변환 {

	public static void main(String[] args) {

		int x = 100; // int는 -21억~21억, 4바이트
		byte y = 120; // byte는 -128~127, 1바이트
		// 큰 <-작 : 자동형변환
		x = y;
		System.out.println("x:" + x);
		
		//int z = 127;
		// 작<-큰: 강제형변환 ()를 이용
		// (자르고싶은 데이터형)
		//byte w = (byte) z;
		
		//int q = 1000;
		// byte t = q;
		// 강제형변환하는 이유는
		// 강제로 변환하고자 하는 타입범위에
		// 값이 들어가야한다.
		
		
		
	}

}
