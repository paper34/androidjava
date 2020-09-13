package 스태틱;

public class 직원 {
	String name; // 이름
	String s; // 성별
	int age; // 나이
	static int count; // 직원 수 count
	static int sum; // 나이 합
	final static String company = "mega";

	public 직원(String name, String s, int age) {
		count++;
		sum = sum + age;
		this.name = name;
		this.s = s;
		this.age = age;
		
	}

	// static 메서드(정적 메서드): 객체생성하지 않아도, 이 기능을 바로 사용 가능
	// 클래스 이름으로 바로 접근해서 사용할 수 잇는 메서드로 만드는 것이 좋다.
	public static String getName() {
		return company; // static메서드 내에서는 인스턴스 사용 불가
	}

	// 자주 사용하는 기능의 메서드는 바로 바로 쓸 수 있게 만들어두는 것이 좋다.
	// Integer.parseInt(), JOPionpane.showInputDialog()
	
	// 일반 메서드: 객체생성후, 참조형 변수의 주소로 접근 가능!
	public int getAvg() {
		return sum / count;
	}

	@Override
	public String toString() {
		return "직원 [이름=" + name + ", 성별=" + s + ", 나이=" + age + "]";
	}
}
