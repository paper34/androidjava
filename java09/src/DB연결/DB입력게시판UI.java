package DB연결;

import javax.swing.JOptionPane;

public class DB입력게시판UI {

	public static void main(String[] args) throws Exception {
		String title = JOptionPane.showInputDialog("title입력");
		String content = JOptionPane.showInputDialog("content입력");
		String writer = JOptionPane.showInputDialog("writer입력");
		
		DB처리게시판전담 db = new DB처리게시판전담();
		db.create(title, content, writer);
	}

}
