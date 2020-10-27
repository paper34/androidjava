package 인터페이스;

public class BananaCar implements carAction {
	
	@Override
	public void run(){
		System.out.println("제로백3초로 달립니다.");
	}
	
	@Override
	public void stop() {
		System.out.println("1초만에 멈췄습니다.");
	}
}
