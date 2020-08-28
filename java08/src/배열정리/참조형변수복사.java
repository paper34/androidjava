package 배열정리;

public class 참조형변수복사 {

	public static void main(String[] args) {
		int[] x = { 1, 2, 3, 4, 5 };
		int[] y = x; // 주소 복사(얕은복사)
		int[] z = x.clone();
		// 배열인 참조형 변수는 깊은 복사를 해야함

		// 얇은복사
		System.out.print("x: ");
		for (int i : x) {
			System.out.print(i + " ");
		}

		System.out.println();
		System.out.print("y: ");
		for (int i : y) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("____________");

		// 깊은복사
		x[0] = 9;

		System.out.println();
		System.out.print("x: ");
		for (int i : x) {
			System.out.print(i + " ");
		}

		System.out.println();
		System.out.print("z: ");
		for (int i : z) {
			System.out.print(i + " ");
		}


	}
}
