package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
		return bag;
		// bag은 참조형 변수, 주소를 전달!
	}

	public ArrayList<BbsVO> all() throws Exception {

		// 3. sql문을 만든다.
		String sql = "select * from bbs";
		PreparedStatement ps = con.prepareStatement(sql);

		// 4. sql문은 전송
		// select의 결과는 검색결과가 담긴 테이블(항목+내용)
		// 내용에는 없을 수도 있고, 많은 수도 있음.
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공.!!");
		// 가방을 넣는 컨테이너 역할을 하게 됨.!
		// <>안에는 컨테이너에 무엇을 넣을지 지정!
		ArrayList<BbsVO> list = new ArrayList<BbsVO>();
		while (rs.next()) { // 결과가 있는지 없는지 체크해주는 메서드
			BbsVO bag = new BbsVO();// 가방만들어서,
			int no2 = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String writer = rs.getString("writer");
			// 가방에 넣기
			bag.setNo(no2); // 커서(위치알려주는 역할)
			bag.setTitle(title);
			bag.setContent(content);
			bag.setWriter(writer);
			// 컨테이너에 넣기
			list.add(bag);
		}
		return list;
		// bag은 참조형 변수, 주소를 전달!
	}
}