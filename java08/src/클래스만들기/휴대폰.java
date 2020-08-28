package 클래스만들기;

public class 휴대폰 { // 틀역할

//휴대폰 class
//-----------
//속성: 색, 크기, 회사 => 멤버 변수 정의
	String color;
	int size;
	String company;
//기능(동작): 전화하다, 문자하다, 검색하다. => 멤버 메서드 정의
	public void 전화하다() {
		System.out.println("전화하다");
	}
	public void 문자ㅣ하다() {
		System.out.println("문자하다");
	}
	public void 검색하다() {
		System.out.println("검색하다");
	}
}
