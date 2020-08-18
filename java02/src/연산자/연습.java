package 연산자;

public class 연습 {

	public static void main(String[] args) {
		byte x =100; 
		int y = x; // 자동형변환
		System.out.println(y); 
		
		//int a = 300;
		//byte b = a;  //int가 127이 넘어가서 강제행변환 불가능
		//System.out.println(b);
		
		double i = 400; // double 8
		int j = (int)i; // int 4   double을 int로 강제형변환
 		System.out.println(j);
		
		int o = 400;
		double p = o;
		System.out.println(p);
	}

}
