package 컬럭션;

import java.util.HashSet;
import java.util.Random;

public class 로또번호생성중복제거 {

	public static void main(String[] args) {

		Random r = new Random();
		HashSet h = new HashSet();

//		for (int i = 0; i < 6; i++) {
//			h.add(r.nextInt(45) + 1);
//			
//		}
		
		while (h.size() < 6) {
			h.add(r.nextInt(45) + 1);
			
		}
		System.out.println(h);
	}

}
