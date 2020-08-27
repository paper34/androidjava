package 영화예매배열;

import java.util.Scanner;

public class 콘솔에서입력 {

	public static void main(String[] args) {
		// 콘솔에서 입력: Scanner
		// 모든 입력의 데이터 타입은 String!!
//		Scanner scan = new Scanner(System.in);
//		System.out.print("이름을 입력 >>");
//		String x = scan.next();
//		System.out.println("나이를 입력>>");
//		System.out.println("이름: " + x);
//		int y = scan.nextInt(); // int <- String 입력
//		System.out.println("내년 나이는" + (y + 1) + "년");

		// 현재키 입력: 150.5
		// 내년키는 170.5

		// 밖에 비가 오나:true
		// ture이면, 우산을 가지고자
		// false이면, 우산을 놓고가자

		Scanner scan2 = new Scanner(System.in);
		System.out.print("현재키 입력>>");
		double mirae = scan2.nextDouble();
		System.out.println("내년키: " + (mirae + 20));

		System.out.print("밖에 비가옴?");
		Boolean rain = scan2.nextBoolean();
		if (rain) {
			System.out.println("우산가져가셈");
		} else {
			System.out.println("우산ㄴㄴ");
		}
		
		System.out.print("당신의 목표는>>");
		scan2.nextLine();
		String life = scan2.nextLine();
		System.out.println("목표는 " + life);

	}
}
