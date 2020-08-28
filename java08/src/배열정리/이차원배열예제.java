package 배열정리;

public class 이차원배열예제 {

	public static void main(String[] args) {
		int[][] jumsu = new int[4][];
		
		int[] kor = {50, 60, 70, 80, 90};
		int[] math = {66, 77, 88};
		int[] eng = {90, 80, 70, 60};
		int[] sci = {77, 100};
		
		jumsu[0] = kor;
		jumsu[1] = math;
		jumsu[2] = eng;
		jumsu[3] = sci;
		
		
//		name[0][]
		for (int i = 0; i < jumsu.length; i++) {
			for (int j = 0; j < jumsu[i].length; j++) {
				System.out.print(jumsu[i][j] + " ");
			}
			System.out.println();
		}
		

	}

}
