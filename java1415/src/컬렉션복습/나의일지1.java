package 컬렉션복습;

import java.util.ArrayList;

public class 나의일지1 {
	public static void main(String[] args) {
		Day day = new Day("자바공부", 10, "강남" );
		Day day2 = new Day("여행", 15, "강원도" );
		Day day3 = new Day("운동", 11, "피트니스" );
		
//		System.out.println("1일차: " + day);
//		System.out.println("2일차: " + day2);
//		System.out.println("3일차: " + day3);
		
		ArrayList<Day> list = new ArrayList<>();
		list.add(day);
		list.add(day2);
		list.add(day3);
		
		파일로저장 file = new 파일로저장();
		file.save(list);
	}
}
