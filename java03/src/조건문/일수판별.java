package 조건문;

public class 일수판별 {

	public static void main(String[] args) {
		int month = 2;
		switch (month) {// 정수(byte, short, int)
						// 실수는 x
						// 문자, 문자열(String)

		case 2:
			System.out.println("28일");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30일");
			break;

		default:
			System.out.println("31일");
			break;
		}

	}

}
