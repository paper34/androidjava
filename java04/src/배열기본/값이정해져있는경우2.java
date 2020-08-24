package 배열기본;

public class 값이정해져있는경우2 {

	public static void main(String[] args) {

		String[] name = { "홍길동", "이길동", "김길동" };

		int[] age = { 20, 19, 18 };

		char[] char1 = { '남', '여', '중' };

		boolean[] food = { true, false, true };

		double[] weight = { 89.1, 75.2, 42.3 };

		for (int i = 0; i < name.length; i++) {
			System.out.println("이름: " + name[i]);
			
			System.out.println("나이: " + age[i] );
			
			System.out.println(char1[i]);
			
			System.out.println("아침" + food[i]);
			
			System.out.println("몸무게: " + weight[i]);
		}
		
		
		for (String a : name) {
			System.out.println(a);
		}
		for (int b : age) {
			System.out.println(b);
		}
		for (char c : char1) {
			System.out.println(c);
		}
		for (boolean d : food) {
			System.out.println(d);
		}
		for (double e : weight) {
			System.out.println(e);
		}
		
		

	}

}
