package 인터페이스;

public class CookManager {

	Icook cook;

	public CookManager(String food) {
		if (food.equals("한식")) {
			cook = new koreanCook();
		} else if( food.equals("중식")) {
			cook = new chineseCook();
		} else {
			cook = new IndoCook();
		}
		
		
	}

	public void soup() {
		cook.soup();
	}

	public void salad() {
		cook.salad();
	}

}
