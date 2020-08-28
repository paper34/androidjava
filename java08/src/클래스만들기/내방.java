package 클래스만들기;

public class 내방 {

	public static void main(String[] args) {
		// . => 접근연산자
		휴대폰 p1 = new 휴대폰();
		// color, size, company 멤버변수 복사 => 자동초기화
		// p1 변수 생성 => 멤버변수들을 가르키는 주소가 들어감.
		p1.color = "흰색";
		p1.size = 7;
		p1.company = "삼성";
		
		System.out.println("p1 휴대폰의 색: " + p1.color);
		System.out.println("p1 휴대폰의 크기: " + p1.size);
		System.out.println("p1 휴대폰의 회사: " + p1.company);
		p1.전화하다();
		
		휴대폰 p2 = new 휴대폰();
		p2.color = "빨강";
		p2.size = 11;
		p2.company = "애플";
		System.out.println();
		System.out.println("p2 휴대폰의 색: " + p2.color);
		System.out.println("p2 휴대폰의 크기: " + p2.size);
		System.out.println("p2 휴대폰의 회사: " + p2.company);
		p2.전화하다();
		
		
		강아지 d1 = new 강아지();
		d1.color = "검정";
		d1.species = "웰시코기";
		System.out.println();
		System.out.println("강아지1의 색: " + d1.color);
		System.out.println("강아지1의 종: " + d1.species);
		System.out.println();
		
		강아지 d2 = new 강아지();
		d2.color = "흰색";
		d2.species = "불독";
		
		System.out.println("강아지2의 색: " + d2.color);
		System.out.println("강아지2의 종: " + d2.species);
		System.out.println();
	}

}
