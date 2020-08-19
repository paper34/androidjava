package 조건문;

import javax.swing.JOptionPane;

public class exam4 {

	public static void main(String[] args) {
		int sprice = 3000, nprice = 5000, stick = 0, note = 0, sres = 0, nres = 0, res = 0;
		// 스티커가격, 노트가격, 스티커, 노트, 스티커총액, 노트총액, 스티커+노트 가격

		String input = JOptionPane.showInputDialog("구매할 스티커 개수?");
		stick = Integer.parseInt(input); // 변환
		sres = stick * sprice; // 스티커 총 가격 = 갯수 * 가격
		System.out.println("스티커 개수: " + stick);
		System.out.println("스티커 가격: " + sprice);
		System.out.println("스티커 총 가격: " + sres);

		String input1 = JOptionPane.showInputDialog("구매할 노트 개수?");
		note = Integer.parseInt(input1); // 변환
		nres = note * nprice; // 노트 총 가격 = 갯수 * 가격
		System.out.println("노트 개수: " + note);
		System.out.println("노트 가격: " + nprice);
		System.out.println("노트 총 가격: " + nres);

		res = sres + nres; // 총합 = 스티커 + 노트

		// 총가격이 25000원 이상시 할인
		if (res >= 25000) {
			res = res - 3000;
			System.out.println("총 결제금액: " + res);
		} else {
			System.out.println("총 결제금액: " + res);
		}
	}

}
