package 배열기본;

public class 배열기본2 {

	public static void main(String[] args) {
		// 배열은 일반적으로 같은 타입을 묶을때 사용!
		// 다양한 타입을 묶을 때는 배열을 쓰지 않음.
		// 배열은 고정된 크기를 가진다. (크기 조절 불가능)
		int[] tep = new int[7];

		tep[0] = 32;
		tep[1] = 31;
		tep[2] = 30;
		tep[3] = 29;
		tep[4] = 28;
		tep[5] = 27;
		tep[6] = 26;

		for (int i = 0; i < tep.length; i++) {
			System.out.println("일주일간 온도: " + tep[i] + "℃");

		}

	}

}
