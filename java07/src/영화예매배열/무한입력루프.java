package 영화예매배열;

import java.util.Scanner;

public class 무한입력루프 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int[] seat = new int[10]; // 좌석마다 예매상황을 저장할 공간들
		int count = 0;
		// 예약 자리, 남은자리 프린트
		while (true) {
			System.out.println("------------------------------");
			for (int i = 1; i < 11; i++) {
				System.out.print(i + "  ");
			}
			System.out.println();
			System.out.println("------------------------------");

			for (int i = 0; i < seat.length; i++) {

				System.out.print(seat[i] + "  ");
				

			}

			System.out.println("\n");
			System.out.print("원하는 좌석 입력 (종료-1) >>");
			// 종료, 예약된자리 표시
			int choice = scan.nextInt();
			if (choice == -1) {
				System.out.println("프로그램 종료!");
				break;
			}
			if (seat[choice - 1] == 0) {
				seat[choice - 1] = 1;
				System.out.println("예약되었습니다.");
				count++;
			} else {
				System.out.println("이미 예약된 자리입니다.");
			}

			System.out.println("갯수: " + count + "결제금액: " + (10000 * count) + "원");
		}

	}

}
