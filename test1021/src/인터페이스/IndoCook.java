package 인터페이스;

public class IndoCook implements Icook {

	@Override
	public void soup() {
		System.out.println("카레");

	}

	@Override
	public void salad() {
		System.out.println("풀때기");

	}

}
