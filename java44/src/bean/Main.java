package bean;

public class Main {

	public static void main(String[] args) {
		int[] num = {1,2,3};
		// 원래의 for문
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
		
		//for-each(하나씩 순서대대로 꺼내온다)
		for (int x : num) {
			System.out.println(x);
		}
		
	}

}
