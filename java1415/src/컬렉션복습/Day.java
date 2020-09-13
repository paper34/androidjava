package 컬렉션복습;

public class Day {
	String doing;
	int time;
	String location;
	static int count; // 전역변수는 자동초기화가 됨. 0으로 초기화;
	static int sum; // 시간 누적
	
	public Day(String doing, int time, String location) {
		count++;
		sum = sum +time;
		this.doing = doing;
		this.time = time;
		this.location =location;
	}
	// 메서드 이름을 동일하게 할 수 있음.
	// 단, 입력값이 달라야 함.
	// 하나의 이름을 메서드 이름으로 해서 여러개 만들 수 있음.
	// 오버로딩(overloading)
	// => 다형성 (하나의 이름으로 다양한 형태의 메서드를 구현)
	// 	  (polymorphism, 폴리모피즘)
	
	@Override // 재정의, 오버라이드, 오버라이딩
	public String toString() {
		return "Day [doing=" + doing + ", time=" + time + ", location=" + location + "]";
	}
}
