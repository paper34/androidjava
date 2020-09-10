package 컬럭션;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class 예제 {

	public static void main(String[] args) {
		// 문제1
		ArrayList list = new ArrayList();
		list.add("박소정");
		list.add("김정민");
		list.add("소지현");
		list.add("김개념");

		for (int i = 0; i < list.size(); i++) {
			System.out.print(i + 1 + "등 " + list.get(i) + " ");

		}
		System.out.println();
		System.out.println("----2등 김정민 반칙 탈락----");
		list.remove(1);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(i + 1 + "등 " + list.get(i));

		}
		System.out.println();
		System.out.println("----------------------");

		// 문제2
		HashMap list2 = new HashMap();
		list2.put(100, "김데이");
		list2.put(200, "김사전");
		list2.put(300, "김구조");
		list2.put(400, "김자료");
		System.out.println(list2);

		// 200 탈퇴, 300 개명
		list2.remove(200);
		list2.put(300, "김충성");
		System.out.println(list2);

		System.out.println("----------------------");

		// 문제3
		HashSet list3 = new HashSet();
		list3.add("유럽");
		list3.add("일본");
		list3.add("필리핀");
		list3.add("캐나다");
		list3.add("미국");
		System.out.println(list3);
		

	}

}
