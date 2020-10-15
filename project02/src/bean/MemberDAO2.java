package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbcp.DBConnectionMgr;

//CRUD중심으로 기능을 정의
//데이터와 관련된 작업(Data Access Object: DAO)
public class MemberDAO2 {
	/*
	 * String url =
	 * "jdbc:mysql://localhost:3366/project02?useUnicode=true&characterEncoding=utf8";
	 * String user = "root"; String password = "1234";
	 */
	
	Connection con;
	DBConnectionMgr dbcp;

	public MemberDAO2() throws Exception {
		dbcp = DBConnectionMgr.getInstance();
		
		
		/*
		 * // 1. connector설정 Class.forName("com.mysql.jdbc.Driver");
		 * System.out.println("1. connector연결 성공.!!");
		 * 
		 * // 2. db연결 con = DriverManager.getConnection(url, user, password);
		 * System.out.println("2. db연결 성공.!!");
		 */
	}

	public boolean create(MemberVO2 vo) throws Exception {
		con = dbcp.getConnection();
		// 3. sql문을 만든다.(create)
		String sql = "insert into member values (?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPw());
		ps.setString(3, vo.getName());
		ps.setString(4, vo.getBirth());
		ps.setString(5, vo.getGender());
		ps.setString(6, vo.getEmail());
		ps.setString(7, vo.getPhone());
		System.out.println("3. SQL생성 성공.!!");

		// 4. sql문은 전송
		int row = ps.executeUpdate();
		System.out.println("4. SQL문 전송 성공.!!");
		boolean result = false;
		if (row == 1) {
			result = true;
		}
		dbcp.freeConnection(con, ps);
		return result;
	}
	
	// id중복체크
		public int read(String id) throws Exception {
			con = dbcp.getConnection();
			// 3. sql문을 만든다.(create)
			String sql = "select * from member where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);

			// 4. sql문은 전송
			// select의 결과는 검색결과가 담긴 테이블(항목+내용)
			// 내용에는 없을 수도 있고, 많은 수도 있음.
			ResultSet rs = ps.executeQuery();
			System.out.println("4. SQL문 전송 성공.!!");
			int result = 0;// 없음.
			if (rs.next() == true) { // 결과가 있는지 없는지 체크해주는 메서드
				// if(rs.next())와 동일함.
				// if문은 rs.next()가 true때만 실행되므로!
				System.out.println("검색결과가 있어요.");
				result = 1; // 있음.

			} else {
				System.out.println("검색결과가 없어요.");
			}

			dbcp.freeConnection(con, ps, rs);
			return result;
			// 0이 넘어가면, 검색결과 없음.
			// 1이 넘어가면, 검색결과 있음.
		}

// id, pw맞는지 로그인 처리
		public boolean read(String id, String pw) throws Exception {
			con = dbcp.getConnection();

			// 3. sql문을 만든다.(create)
			String sql = "select * from member where id = ? and pw = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);

			// 4. sql문은 전송
			// select의 결과는 검색결과가 담긴 테이블(항목+내용)
			// 내용에는 없을 수도 있고, 많은 수도 있음.
			ResultSet rs = ps.executeQuery();
			System.out.println("4. SQL문 전송 성공.!!");
			boolean result = false;// 로그인이 not!인 상태!
			if (rs.next() == true) { // 결과가 있는지 없는지 체크해주는 메서드
				System.out.println("로그인 ok.");
				result = true; // 있음.
			} else {
				System.out.println("로그인 not.");
			}
			dbcp.freeConnection(con, ps, rs);
			return result;
			// false면 로그인not.
			// true면 로그인ok.
		}
		
		public boolean create(String id, String name) throws Exception {
			con = dbcp.getConnection();
			// 3. sql문을 만든다.(create)
			String sql = "insert into member values (?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, null);
			ps.setString(3, name);
			ps.setString(4, null);
			ps.setString(5, null);
			ps.setString(6, null);
			ps.setString(7, null);

			System.out.println("3. SQL생성 성공.!!");

			// 4. sql문은 전송
			int row = ps.executeUpdate();
			boolean result = false;
			if (row == 1) {
				result = true;
			}
			System.out.println("4. SQL문 전송 성공.!!");

			dbcp.freeConnection(con, ps);
			return result;
		}
		
		//회원정보수정을 위한 메서드 (id로 검색)
		public MemberVO2 one(String id) throws Exception {
			con = dbcp.getConnection();
			String sql = "select * from member where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);

			// 4. sql문은 전송
			ResultSet rs = ps.executeQuery();
			System.out.println("4. SQL문 전송 성공.!!");
			MemberVO2 bag = new MemberVO2();// 가방만들어서,
			if (rs.next() == true) { // 결과가 있는지 없는지 체크해주는 메서드
				// if(rs.next())와 동일함.
				// if문은 rs.next()가 true때만 실행되므로!
				System.out.println("검색결과가 있어요.");
				//검색결과 하나씩 꺼내
				String id2 = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String birth = rs.getString("birth");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				
				// 가방에 넣기
				bag.setId(id2);
				bag.setPw(pw);
				bag.setName(name);
				bag.setBirth(birth);
				bag.setGender(gender);
				bag.setPhone(phone);
				bag.setEmail(email);
			} else {
				System.out.println("검색결과가 없어요.");
			}

			dbcp.freeConnection(con, ps, rs);

			return bag;
			// bag은 참조형 변수, 주소를 전달!
		}
		
		
		public boolean update(MemberVO2 vo) throws Exception {
			con = dbcp.getConnection();
			// 3. sql문을 만든다.(create)
			String sql = "update member set pw=?, name=?, birth=?, gender=?, phone=?, email=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
	
			ps.setString(1, vo.getPw());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getBirth());
			ps.setString(4, vo.getGender());
			ps.setString(5, vo.getPhone());
			ps.setString(6, vo.getEmail());
			ps.setString(7, vo.getId());
			
			System.out.println("3. SQL생성 성공.!!");

			// 4. sql문은 전송
			int row = ps.executeUpdate();
			dbcp.freeConnection(con, ps);
			System.out.println("4. SQL문 전송 성공.!!");
			boolean result = false;
			if (row == 1) {
				result = true;
			}
			return result;
		}	
		
		public boolean delete(String id) throws Exception {
		con = dbcp.getConnection();
		String sql = "delete from member where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		System.out.println("3. SQL생성 성공.!!");
    	// 4. sql문은 전송

		int row = ps.executeUpdate();
		boolean result = false;
		if (row == 1) {
			result = true;
		}
		System.out.println("4. SQL문 전송 성공.!!");
		dbcp.freeConnection(con, ps);
		return result;
	}
		
}