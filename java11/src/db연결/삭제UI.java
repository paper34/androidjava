package db연결;

import javax.swing.JOptionPane;

public class 삭제UI {

	public static void main(String[] args) throws Exception{
		
		String id = JOptionPane.showInputDialog("삭제할 id");
		MemberDAO delete = new MemberDAO();
		delete.delete(id);
	}

}
