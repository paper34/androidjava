package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BbsDAO {
	Connection con;

	public BbsDAO() throws Exception {
		// 1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector연결 성공.!!");

		// 2. db연결
		String url = "jdbc:mysql://localhost:3366/shop1?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공.!!");

	}

	public boolean create(BbsVO vo) throws Exception {

		// 3. sql문을 만든다.(create)
		String sql = "insert into bbs values (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, vo.getNo());
		ps.setString(2, vo.getTitle());
		ps.setString(3, vo.getContent());
		ps.setString(4, vo.getWriter());
		System.out.println("3. SQL생성 성공.!!");

		// 4. sql문은 전송
		int row = ps.executeUpdate();
		boolean result = false;
		if (row == 1) {
			result = true;
		}
		System.out.println("4. SQL문 전송 성공.!!");

		ps.close();
		con.close();
		return result;

	}

	public void printPretty() {
		System.out.println("-----------");
		System.out.println("************");
	}

	public BbsVO one(int no) throws Exception {

		// 3. sql문을 만든다.
		String sql = "select * from bbs where no = ?";
		// select * from member where id = 'park' //setString
		// select * from bbs where no = 1 //setInt
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);

		// 4. sql문은 전송
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공.!!");
		BbsVO bag = new BbsVO();// 가방만들어서,
		if (rs.next()) { // 결과가 있는지 없는지 체크해주는 메서드
			System.out.println("검색결과가 있어요.");
			int no2 = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String writer = rs.getString("writer");
			// 가방에 넣기
			bag.setNo(no2);
			bag.setTitle(title);
			bag.setContent(content);
			bag.setWriter(writer);
			System.out.println("검색결과 ino2: " + no2);
			System.out.println("검색결과 title: " + title);
			System.out.println("검색결과 content: " + content);
			System.out.println("검색결과 writer: " + writer);
		} else {
			System.out.println("검색결과가 없어요.");
		}
		rs.close();
		ps.close();
		con.close();
		return bag;
		// bag은 참조형 변수, 주소를 전달!
	}

	public List<BbsVO> all() throws Exception {

		// 3. sql문을 만든다.
		String sql = "select * from bbs";
		PreparedStatement ps = con.prepareStatement(sql);

		// 4. sql문은 전송
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공.!!");
		
		List<BbsVO> list = new ArrayList<BbsVO>();
		
		while (rs.next()) { 
			BbsVO bag = new BbsVO();
			
			bag.setNo(rs.getInt("no")); 
			bag.setTitle(rs.getString("title"));
			bag.setContent(rs.getString("content"));
			bag.setWriter(rs.getString("writer"));
			
			list.add(bag);
		}
		rs.close();
		ps.close();
		con.close();
		return list;
	}
	//title검색
	public List<BbsVO> all(String title) throws Exception {

		// 3. sql문을 만든다.
		String sql = "select * from bbs where title = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, title);
		
		// 4. sql문은 전송
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공.!!");
		
		List<BbsVO> list = new ArrayList<BbsVO>();
		
		while (rs.next()) { 
			BbsVO bag = new BbsVO();
			
			bag.setNo(rs.getInt("no")); 
			bag.setTitle(rs.getString("title"));
			bag.setContent(rs.getString("content"));
			bag.setWriter(rs.getString("writer"));
			
			list.add(bag);
		}
		rs.close();
		ps.close();
		con.close();
		return list;
	}
	//content 검색
	public List<BbsVO> all2(String content) throws Exception {

		// 3. sql문을 만든다.
		String sql = "select * from bbs where content like '" + content + "%'";
		PreparedStatement ps = con.prepareStatement(sql);

		// 4. sql문은 전송
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공.!!");
		
		List<BbsVO> list = new ArrayList<BbsVO>();
		
		while (rs.next()) { 
			BbsVO bag = new BbsVO();
			
			bag.setNo(rs.getInt("no")); 
			bag.setTitle(rs.getString("title"));
			bag.setContent(rs.getString("content"));
			bag.setWriter(rs.getString("writer"));
			
			list.add(bag);
		}
		rs.close();
		ps.close();
		con.close();
		return list;
	}
	//수정
	public boolean update(BbsVO vo) throws Exception {

		// 3. sql문을 만든다.(create)
		String sql = "update bbs set title = ?, content = ?, writer = ? where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, vo.getTitle());
		ps.setString(2, vo.getContent());
		ps.setString(3, vo.getWriter());
		ps.setInt(4, vo.getNo());
		System.out.println("3. SQL생성 성공.!!");

		// 4. sql문은 전송
		int row = ps.executeUpdate();
		System.out.println("4. SQL문 전송 성공.!!");

		ps.close();
		con.close();
		boolean result = false;
		if (row == 1) {
			result = true;
		}
		return result;
	}
}