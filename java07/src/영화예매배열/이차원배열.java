package 영화예매배열;

import java.util.Scanner;

public class 이차원배열 {

	public static void main(String[] args) {
		// 변수 선언
		Scanner scan = new Scanner(System.in);
		int[][] seat = new int[3][10];
		int count = 0;

		// 2차원 배열의 각 행 열의 개수는 유동적
		// 0행은 열개수 5개
		// 1행은 열개수10개

		// 행 , 열 생성
		while (true) {
			System.out.println();
			System.out.println("  " + " 1  2  3  4  5  6  7  8  9");
			System.out.println("----------------------------");

			seat[0][0] = 1;
			seat[1][0] = 2;
			seat[2][0] = 3;
			for (int i = 0; i < seat.length; i++) {// 행의 개수=>3(0~2)
				for (int j = 0; j < seat[i].length; j++) {
					System.out.print(seat[i][j] + "  ");
				}
				System.out.println();
			}

			// 입력
			System.out.println("세로)원하는 좌석 입력(1~3 종료-1) >>");
			int choice = scan.nextInt();
			// 프로그램 종료 or 잘못입력 시 continue
			if (choice == -1) {
				System.out.println("프로그램 종료!");
				break;
			} else if (choice > 3 | choice < -1) {
				System.out.println("잘못된 숫자를 입력하셨습니다. 다시입력하세요");
				continue;
			}

			System.out.println("가로)원하는 좌석 입력(1~9 종료-1) >>");
			int choice2 = scan.nextInt();
			if (choice2 == -1) {
				System.out.println("프로그램 종료!");
				break;
			} else if (choice > 10 | choice < 1) {
				System.out.println("잘못된 숫자를 입력하셨습니다. 다시입력하세요");
				continue;
			}
			if (seat[choice - 1][choice2] == 1) {
				System.out.println("이미 예약된 자리입니다.");
			} else {
				seat[choice - 1][choice2] = 1;
				System.out.println("예약됐습니다.");
				count++;
				System.out.println("총결제금액:" + (10000 * count));
			}

		}
	}

}
