package 배열의응용;

public class 가족 {

	public static void main(String[] args) {
		String[] names = { "아버지", "어머니", "형", "나 ", "동생" };
		int[] age = {100, 88, 33, 24, 10};
		double[] tall = { 177.5, 152.2, 190.3, 167.7, 155.3};
		
		System.out.println("우리집 식구 정리");
		System.out.println("_______________________");
		System.out.println("이름" + "\t" + "나이" + "\t" + "키");
		for (int i = 0; i < tall.length; i++) {
			System.out.println(names[i] +"\t" + age[i] + "\t" + tall[i] );
		}
	}

}
