package 추상클래스;

public class PhoneMain {

	public static void main(String[] args) {
		ApplePhone11 a11 = new ApplePhone11();
		ApplePhone11 a12 = new ApplePhone11();
		
		a11.camera();
		a12.camera();
		//ApplePhone a = new ApplePhone();
		//Phone p = new Phone(); 불안정한 추상클래스는 객체생성이 불가!!!
	}

}
