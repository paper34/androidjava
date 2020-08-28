package 클래스사용하기;

import 클래스만들기.용돈계산기;

public class 내용돈을계산해보자 {

	public static void main(String[] args) {
		용돈계산기 m1 = new 용돈계산기();

		int money = 100000;
		int month = 6;

		int sum = m1.mul(month, money);
		System.out.println("6개월 동안 용돈: " + sum + "원");

		if (sum > 500000) {
			System.out.println("너 용돈 너무많아서: " + (sum = 500000) + "원");
		} else if (sum < 500000) {
			System.out.println("너 용돈: " + (sum + 150000) + "원");
		}

		
		용돈계산기 m2 = new 용돈계산기();
		int month1 = 600000;
		int month2 = 500000;
		
		int sum2 = m2.add(month1, month2);
		System.out.println("---------------------------");
		System.out.println("일년동안 용돈: " + sum2 + "원");
	}

}
