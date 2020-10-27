package 인터페이스;

import javax.swing.JOptionPane;

public class CookMain {

	public static void main(String[] args) {
		String food = JOptionPane.showInputDialog("뭐드릴래요? 한식 or 중식 or 인도음식?");
		CookManager m = new CookManager(food);
		m.salad();
		m.soup();
	}

}
