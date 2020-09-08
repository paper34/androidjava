package db연결;

import javax.swing.JOptionPane;

public class 회원정보수정UI {

	public static void main(String[] args) throws Exception {
		// 컨트롤 + 알트 + 화살표아래: 한줄복사(블록설정x)
		String id = JOptionPane.showInputDialog("검색할 id입력");
		String tel = JOptionPane.showInputDialog("수정할  tel입력");
		
		MemberDAO db = new MemberDAO();
		db.update(tel, id);
		
		
	}
}
