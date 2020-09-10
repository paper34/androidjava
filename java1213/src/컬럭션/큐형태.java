package 컬럭션;

import java.util.LinkedList;

public class 큐형태 {

	public static void main(String[] args) {
		// 큐형태 = 맨 앞에거부터 삭제
		LinkedList milk = new LinkedList();
		milk.add("상한우유");
		milk.add("싱싱우유");
		milk.add("내일우유");
		for (int i = 0; i < milk.size(); i++) {
			System.out.println(milk.get(i));
		}
		milk.remove();
		System.out.println("------");
		for (int i = 0; i < milk.size(); i++) {
			System.out.println(milk.get(i));
		}
		milk.remove();
		System.out.println("------");
		for (int i = 0; i < milk.size(); i++) {
			System.out.println(milk.get(i));
		}
		System.out.println(milk);
	}

}
