package 추상클래스;

public abstract class cat implements Animal {

	
	
	@Override
	public void eat() {
		System.out.println("샴 밥먹는다");

	}

	@Override
	public void sleep() {
		System.out.println("샴 잔다.");

	}

}
