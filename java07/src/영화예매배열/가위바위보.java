package 영화예매배열;

import java.util.Random;
import java.util.Scanner;

public class 가위바위보 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random random = new Random();

		int total = 0;
		int comWin = 0;
		int /* 가위 */ sW = 0, /* 바위 */rW = 0, /* \보 */pW = 0;
		int same = 0;

		while (true) {
			// 종료
			System.out.println("가위 0) 바위 1) 보2) 중 하나를 입력하시오. (종료는 3) >>");
			int me = sc.nextInt();
			if (me == 3) {
				System.out.println("종료합니다");
				break;
			}
			// 시작
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
			System.out.println("★★★★★★★★★★★★★Game Start★★★★★★★★★★★★★");

			// 컴퓨터 랜덤값 0~2
			int com = random.nextInt(3);

			// 가위 바위 보
			total++; // 전체횟수

			if (me == 0) { // me == 가위
				if (com == 0) { // com == 가위
					System.out.println("비겼음");
					same++;
				} else if (com == 1) { // com == 바위
					System.out.println("컴퓨터 승리");
					comWin++;
				} else if (com == 2) { // com == 보
					System.out.println("내가 승리");
					sW++;
				}

			} else if (me == 1) { // me == 바위
				if (com == 0) { // com == 가위
					System.out.println("내가 승리");
					rW++;
				} else if (com == 1) { // com == 바위
					System.out.println("비겼음");
					same++;
				} else if (com == 2) { // com == 보
					System.out.println("컴퓨터 승리");
					comWin++;
				}

			} else if (me == 2) { // me == 보
				if (com == 0) { // com == 가위
					System.out.println("컴퓨터 승리");
					comWin++;
				} else if (com == 1) { // com == 바위
					System.out.println("내가 승리");
					pW++;
				} else if (com == 2) { // com == 보
					System.out.println("비겼음");
					same++;
				}

			}
			/// 출력
			System.out.println("게임 전체 횟수 " + total + "회");
			System.out.println("컴퓨터 전체 승리 횟수 " + comWin + "회");
			System.out.println("나의 가위로 이긴 횟수 " + sW + "회");
			System.out.println("나의 바위로 이긴 횟수 " + rW + "회");
			System.out.println("나의 보로 이긴 횟수 " + pW + "회");
			System.out.println("게임 전체 비긴 횟수 " + same + "회");
			System.out.println();

		}
	}

}
