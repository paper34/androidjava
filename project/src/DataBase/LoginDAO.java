package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginDAO {

	// 로그인 처리
	public boolean login(String user_id, String user_pw) throws Exception {
		// 1. connector 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector연결 성공");

		// 2. db연결
		String url = "jdbc:mysql://localhost:3366/corona";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공");

		// 3. sql문
		String sql = "select * from login where user_id = ? and user_pw = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user_id);
		ps.setString(2, user_pw);
		System.out.println("3. SQL생성 성공");

		// 4. sql문을 전송
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공");

		boolean result = false;
		if (rs.next()) {
			System.out.println("로그인 ok.");
			result = true;

		} else {
			System.out.println("로그인 not.");
		}
		return result;

	}
	//이름을 통해서 회원정보검색(아이디찾기)
	public LoginVO one(String user_name) throws Exception {
		// 1. connector 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector연결 성공");

		// 2. db연결
		String url = "jdbc:mysql://localhost:3366/corona?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공");

		// 3. sql문
		String sql = "select * from login where user_name = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user_name);
		System.out.println("3. SQL생성 성공");

		// 4. sql문을 전송
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공");
		LoginVO bag = new LoginVO();
		if (rs.next()) { // 결과가 있는지 없는지 체크해주는 메서드
			System.out.println("검색결과가 있어요.");

			String user_id = rs.getString("user_id");
			String user_pw = rs.getString("user_pw");
			String user_tel = rs.getString("user_tel");
			String user_birth = rs.getString("user_birth");

			// 가방에 넣기
			bag.setUser_id(user_id);
			bag.setUser_pw(user_pw);
			bag.setUser_tel(user_tel);
			bag.setUser_birth(user_birth);

		} else {
			JOptionPane no = new JOptionPane("검색결과가 없습니다.");
			JDialog dialog = no.createDialog("오류");
			dialog.setLocation(300, 450);
			dialog.setVisible(true);
		}
		return bag;
	}

	// 아이디를 통해 회원정보 찾기(삭제)
	public LoginVO out(String user_id) throws Exception {
		// 1. connector 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector연결 성공");

		// 2. db연결
		String url = "jdbc:mysql://localhost:3366/corona?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공");

		// 3. sql문
		String sql = "select * from login where user_id = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user_id);
		System.out.println("3. SQL생성 성공");

		// 4. sql문을 전송
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공");
		LoginVO bag = new LoginVO();
		if (rs.next()) { // 결과가 있는지 없는지 체크해주는 메서드
			System.out.println("검색결과가 있어요.");

			String user_pw = rs.getString("user_pw");
			String user_name = rs.getString("user_name");
			String user_tel = rs.getString("user_tel");
			String user_birth = rs.getString("user_birth");

			// 가방에 넣기
			bag.setUser_pw(user_pw);
			bag.setUser_name(user_name);
			bag.setUser_tel(user_tel);
			bag.setUser_birth(user_birth);

		} else {
			JOptionPane no = new JOptionPane("검색결과가 없습니다.");
			JDialog dialog = no.createDialog("오류");
			dialog.setLocation(300, 450);
			dialog.setVisible(true);

		}
		return bag;
	}

	// 회원 탈퇴
	public void delete(LoginVO bag) throws Exception {
		// 1. connector 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector연결 성공");

		// 2. db연결
		String url = "jdbc:mysql://localhost:3366/corona?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공");

		// 3. sql문 (delete)
		String sql = "delete from login where user_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, bag.getUser_id());
		System.out.println("3. SQL생성 성공");

		// 4. sql문을 전송
		ps.executeUpdate();
		System.out.println("4. SQL문 전송 성공");
	}

	// 회원정보 수정
	public void update(LoginVO bag) throws Exception {

		// 1. connector 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector연결 성공");

		// 2. db연결
		String url = "jdbc:mysql://localhost:3366/corona?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공");

		// 3. sql문을 만든다.
		String sql = "update login set user_pw = ?, user_name = ?, user_tel = ?, user_birth= ? where user_id = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, bag.getUser_pw());
		ps.setString(2, bag.getUser_name());
		ps.setString(3, bag.getUser_tel());
		ps.setString(4, bag.getUser_birth());
		ps.setString(5, bag.getUser_id());
		System.out.println("3. SQL생성 성공");

		// 4. sql문을 전송
		ps.executeUpdate();
		System.out.println("4. SQL문 전송 성공");
	}

}
