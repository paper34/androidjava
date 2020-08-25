package 배열의응용;

public class 점수 {

	public static void main(String[] args) {
		// 배열
		String[] names = { "국어", "수학", "과학", "컴퓨터", "영어" };
		int[] one = { 100, 99, 77, 87, 66 };
		int[] two = one.clone();
		two[2] = 44;
		two[4] = 55;

		// 1, 2학기 프린트
		for (int i = 0; i < two.length; i++) {
			System.out.println("1학기 : " + names[i] + "\t" + one[i]);
			System.out.println("2학기 : " + names[i] + "\t" + two[i]);
		}
		System.out.println("\n------------------");

		// 점수변경 수, 과목명
		int count = 0;
		for (int i = 0; i < two.length; i++) {
			if (one[i] != two[i]) {
				count++;
				System.out.println("변경된 과목명: " + names[i]);
			}
		}
		System.out.println("점수가 변경된 과목 수:" + count + "개");

		// 1, 2학기 평균
		int sum = 0;
		int sum2 = 0;

		for (int i = 0; i < two.length; i++) {
			sum = sum + one[i];
			sum2 = sum2 + two[i];
		}
		System.out.println("1학기 평균값: " + (sum / 5));
		System.out.println("2학기 평균값: " + (sum2 / 5));

		// 1, 2학기 평균 비교
		if (sum > sum2) {
			System.out.println("1학기 평균이 더 높습니다");
		}
		if (sum < sum2) {
			System.out.println("2학기 평균이 더 높습니다");
		}

	}

}
