package 스태틱;

public class 창업 {
	public static void main(String[] args) {
		//직원(String name, String s, int age)
		직원 wk1 = new 직원("임아무개", "남", 24); 
		직원 wk2 = new 직원("김아무개", "여", 23);
		직원 wk3 = new 직원("박아무개", "남", 25);
		
		//출력
		 System.out.println("전체 직원 수: " + 직원.count + "명");
		 System.out.println("직원 평균나이: " + 직원.sum/직원.count + "살");
		 System.out.println(wk1.getAvg());
		 System.out.println(wk2);
		 System.out.println(wk3);
	}
}
