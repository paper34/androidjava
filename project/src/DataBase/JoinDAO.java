package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JoinDAO {

	public void create(JoinVO vo) throws Exception { //회원 가입 입력
		System.out.println("DB에 저장처리함");
	
		Class.forName("com.mysql.jdbc.Driver");
	
		System.out.println("1. connector 설정 성공");
	
		String url = "jdbc:mysql://localhost:3366/corona?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. shop 연결 성공");
		

		String sql = "insert into login values (?, ?, ?, ?, ?)";
	

		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, vo.getUser_id()); //회원가입 ID
		ps.setString(2, vo.getUser_pw()); //회원가입 PW
		ps.setString(3, vo.getUser_name()); //회원가입 이름
		ps.setString(4, vo.getUser_tel()); //회원가입 전화번호
		ps.setString(5, vo.getUser_birth()); //회원가입 생년월일

		System.out.println("3. SQL문 생성 성공");

		ps.executeUpdate();
		System.out.println("4. SQL문을 mySQL로 네트워크 전송 성공");
		
		

	}


	public boolean read(JoinVO vo) throws Exception { // 회원가입 ID 중복확인
		System.out.println("DB에 저장처리함");
		
		Class.forName("com.mysql.jdbc.Driver");
	
		System.out.println("1. connector 설정 성공");
	
		String url = "jdbc:mysql://localhost:3366/corona";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. shop 연결 성공");
		
		
		
		String sql = "select * from login where user_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, vo.getUser_id()); //중복확인 할 ID
		
		
		
		System.out.println("3. SQL문 생성 성공!!");
		
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공!!");

		boolean result = false;
		if (rs.next()==true) {// 결과가 있는지 없는지 체크해주느 메서드

			result = true;	
		} else {
			
		}
		return result;
		
		
	}

	

}
