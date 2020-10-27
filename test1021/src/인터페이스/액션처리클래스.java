package 인터페이스;

public class 액션처리클래스 implements MyAction {
	public void click() {
		System.out.println("클릭하면 인터넷 연결됨");
	}
	
	public void doubleClick() {
		System.out.println("더블클릭하면 어쩌고저쩌고");
	}
}
