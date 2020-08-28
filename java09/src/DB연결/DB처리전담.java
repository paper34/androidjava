package DB연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

// 특정한 방법을 처리하는 클래스: 방법(model, db처리) 클래스
public class DB처리전담 {
	// DB 처리하는 방법이 4단계로 정해져 있다.
		public void create(String id, String pw, String name, String tel) throws Exception {

		System.out.println("DB에 저장 처리 함");
		Class.forName("com.mysql.jdbc.Driver");

		// 자바에서는 에러가 너무 많이 발생할거 같은 상황에서는 반드시
		// 에러처리를 반드시 해주어야함.
		// 네트워크 연결, db연결, 파일연결, cpu연결

		System.out.println("1. connector 설정 성공");

		// 1. connector 설정
		// 2. db연결
		// 1)url: ip+port+db명
		// 2)username: root
		// 3)password: 1234

		String url = "jdbc:mysql://localhost:3366/shop";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);

		// db 연동 index는 1부터 시작!
		String sql = "insert into member values (?, ?, ?, ?)";

		// 컴퓨터는 이 문장을 그냥 String으로 인식!
		System.out.println("2. shop연결성공");

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		ps.setString(3, name);
		ps.setString(4, tel);
		System.out.println("3.sql문 성공");

		ps.executeUpdate();
		System.out.println("4. DB연결 성공");

	}

	public void create1() {
		// JOptionPane.showMessageDialog(null, "DB에 저장 처리 함");
		
	}

	public void read() {
		JOptionPane.showMessageDialog(null, "DB에 검색 처리 함");
	}

	public void update() {
		JOptionPane.showMessageDialog(null, "DB에 수정 처리 함");
	}

	public void delete() {
		JOptionPane.showMessageDialog(null, "DB에 삭제 처리 함");

	}
}
