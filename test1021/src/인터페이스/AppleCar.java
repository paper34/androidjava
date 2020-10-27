package 인터페이스;

public class AppleCar implements carAction {
	@Override
	public void run() {
		System.out.println("제로백5초로 달립니다.");
	}
	
	@Override
	public void stop() {
		System.out.println("3초만에 멈췄습니다.");
	}
}
