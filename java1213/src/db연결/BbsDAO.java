package db연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BbsDAO {
	// 글쓰기 입력
	public void create(BbsVO vo) throws Exception {
		// 1. connector 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector연결 성공");

		// 2. db연결
		String url = "jdbc:mysql://localhost:3366/shop1?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공");

		// 3. sql문을 만든다.(create)
		String sql = "insert into bbs values (?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, vo.getNo());
		ps.setString(2, vo.getWriter());
		ps.setString(3, vo.getTitle());
		ps.setString(4, vo.getContent());
		System.out.println("3. SQL생성 성공");

		// 4. sql문을 전송
		ps.executeUpdate();
		System.out.println("4. SQL문 전송 성공");

	}

	// 번호 입력해서 아이디 검색
	public BbsVO one(int no) throws Exception {
		// 1. connector 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector연결 성공");

		// 2. db연결
		String url = "jdbc:mysql://localhost:3366/shop1?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공");

		// 3. sql문
		String sql = "select * from bbs where no = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		System.out.println("3. SQL생성 성공");

		// 4. sql문을 전송
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공");

		BbsVO bag = new BbsVO();
		if (rs.next()) { // 결과가 있는지 없는지 체크해주는 메서드
			System.out.println("검색결과가 있어요.");

			int no2 = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String writer = rs.getString("writer"); // 가방에서 꺼내기

			// 가방에 넣기

			bag.setNo(no2);
			bag.setTitle(title);
			bag.setContent(content);
			bag.setWriter(writer);
		} else {
			System.out.println("검색결과가 없어요.");
		}
		return bag;
	}

	// 글수정
	public void update(BbsVO bag) throws Exception {

		// 1. connector 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector연결 성공");

		// 2. db연결
		String url = "jdbc:mysql://localhost:3366/shop1?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공");

		// 3. sql문을 만든다.
		String sql = "update bbs set title = ?, content = ?, writer = ? where no = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, bag.getWriter());
		ps.setString(2, bag.getTitle());
		ps.setString(3, bag.getContent());
		ps.setInt(4, bag.getNo());
		System.out.println("3. SQL생성 성공");

		// 4. sql문을 전송
		ps.executeUpdate();
		System.out.println("4. SQL문 전송 성공");
	}

	// 삭제
	public void delete(BbsVO bag) throws Exception {
		// 1. connector 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector연결 성공");

		// 2. db연결
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공");

		// 3. sql문 (delete)
		String sql = "delete from bbs where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, bag.getNo());
		System.out.println("3. SQL생성 성공");

		// 4. sql문을 전송
		ps.executeUpdate();
		System.out.println("4. SQL문 전송 성공");
	}

	// 전체 목록
	public ArrayList<BbsVO> all() throws Exception {
		// 가방을 넣는 컨테이너 역할을 하게 됨.!
		// < >안에는 컨테이너에 무엇을 넣을지 지정!

		// 1. connector 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector연결 성공");

		// 2. db연결
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공");

		// 3. sql문
		String sql = "select * from bbs";
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL생성 성공");

		// 4. sql문을 전송
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공");

		ArrayList<BbsVO> list = new ArrayList<BbsVO>();
		while (rs.next()) {
			BbsVO bag = new BbsVO();

			int no2 = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String writer = rs.getString("writer"); // 가방에서 꺼내기

			// 가방에 넣기
			bag.setNo(no2); // 커서(위치알려주는 역할)
			bag.setTitle(title);
			bag.setContent(content);
			bag.setWriter(writer);

			// 컨테이너에 넣기
			list.add(bag);
		}
		return list;
	}

}
