package 클래스만들기;

public class 계좌 {

	public static void main(String[] args) {
		우리가족계좌 c1 = new 우리가족계좌();
		c1.title = "우리 가족 계좌정보";
		c1.name = "홍길동";
		c1.account = "튼튼적금";
		c1.money = 1000;
		
		System.out.println(c1.title + " ");
		System.out.println("____________");
		System.out.println(c1.name + " "+ c1.account + c1.money);
		
		우리가족계좌 c2 = new 우리가족계좌();

		c2.name = "박길동";
		c2.account = "튼튼예금";
		c2.money = 2000;

		우리가족계좌 c3 = new 우리가족계좌();

		c3.name = "홍기사";
		c3.account = "다음적금";
		c3.money = 3000;
		
		

	}

}
