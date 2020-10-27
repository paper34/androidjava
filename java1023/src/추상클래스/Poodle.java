package 추상클래스;

public abstract class Poodle implements Animal {

	@Override
	public void eat() {
		System.out.println("푸들 밥먹는다");

	}

	@Override
	public void sleep() {
		System.out.println("푸들 잔다!");

	}

}
