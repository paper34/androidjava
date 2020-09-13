package 컬렉션복습;


public class 나의일지2 {
	
	public static void main(String[] args) {
		Day day = new Day("자바공부", 10, "강남" );
		System.out.println(Day.count + "개 생성됨");
		
		Day day2 = new Day("여행", 15, "강원도" );
		System.out.println(Day.count + "개 생성됨");
		
		Day day3 = new Day("운동", 11, "피트니스" );
		System.out.println(Day.count + "개 생성됨");
		System.out.println(Day.sum + "누적 시간");
		
		System.out.println("평균시간은: " + day.sum/day.count + "시간");
		System.out.println(day);
		System.out.println(day2);
		System.out.println(day3);
	}
}
