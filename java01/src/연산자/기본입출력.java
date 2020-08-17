package 연산자;

import javax.swing.JOptionPane;

public class 기본입출력 {

	public static void main(String[] args) {
		// 창을 띄워서 입력을 받아보자
		// 창을 띄워서 출력을 해보자
		// 자주 사용하는 것은 부품의 대문자를 그대로 쓴다.
		// 특정한 일을 전담하는 부품을 만들어, 특정한 처리를 할 때
		// 부품을 지정함.
		
		String name = JOptionPane.showInputDialog("당신의 이름은?");
		// 변수선언 name = 입력("")!
		//입력 받는 창
		
		System.out.println("당신의 이름은" + name);
		//	입력받는 값을 출력
		
		String age = JOptionPane.showInputDialog("당신의 나이는?");
		// 변수선언 age = 입력
		//키보드로 입력한 데이터 타입은 무조건 String!
		//String으로 저장된 데이터를 int/String쓸지는 내가 결정!
		//계산의 유무에 따라 계산해야하는 경우는 int로 변환해주어야함. 문자만출력은 Spring!
		//숫자로 바꿔보자!!
		
		int age2 = Integer.parseInt(age); //문자를 숫자로
		// 변수선언 age2 = 입력받는 age는 문자이기에 계산이 가능한 숫자로 변환
		
		int lastAge = age2 - 1;
		// 작년나이 변수선언 =  나이-1
		
		System.out.println("당신의  작년 나이는" + lastAge + "살");
		// 작년나이 출력
	}

}
