package 제너릭프로그래밍;

import java.util.ArrayList;

public class CarTest {

	public static void main(String[] args) {
		car<String> c1 = new car<>("Big");
		System.out.println(c1.getSize());
		
		car<Integer> c2 = new car<>(100);
		System.out.println(c2.getSize());
		
		car<VO> c3 = new car<>(new VO());
		System.out.println(c3.getSize());
		
		ArrayList<VO> list  = new ArrayList<>();
		list.add(new VO());
		System.out.println(list);
		
	}
	
}
