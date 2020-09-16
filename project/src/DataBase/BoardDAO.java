package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class BoardDAO {

	public void create(BoardVO vo) throws Exception {
		System.out.println("DB에 저장처리함");
		Date today = new Date();
		
	    //System.out.println(today);
	    
	    SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
	    SimpleDateFormat time = new SimpleDateFormat("HH:mm");
	    
	    
	    String creat_day = date.format(today);
	    String creat_time = time.format(today);

	    Class.forName("com.mysql.jdbc.Driver");

		System.out.println("1. connector 설정 성공");

		String url = "jdbc:mysql://localhost:3366/corona?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. shop 연결 성공");

		String sql = "insert into board values (null, ?, ?, ?, ?, ?)";
		// db저장될 이름 이자리에 안넣겠다

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, vo.getTitle());
		ps.setString(2, vo.getWriter());
		ps.setString(3, vo.getContent());
		ps.setNString(4, creat_day);
		ps.setNString(5, creat_time);
		
	

		System.out.println("3. SQL문 생성 성공");

		ps.executeUpdate();
		System.out.println("4. SQL문을 mySQL로 네트워크 전송 성공");

	}

	
	
	
	public BoardVO read(int no) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector연결 성공.!!");

		String url = "jdbc:mysql://localhost:3366/corona";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공.!!");

		String sql = "select * from board where no = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);

		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공.!!");
		
		BoardVO bag = new BoardVO();// 가방만들어서,
		
		
		if (rs.next()) { // 결과가 있는지 없는지 체크해주는 메서드
			int no1 = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String writer = rs.getString("writer");
			String date = rs.getString("create_day");
			String time = rs.getString("create_time");

			bag.setNo(no1);
			bag.setTitle(title);
			bag.setContent(content);
			bag.setWriter(writer);
			bag.setCreate_date(date);
			bag.setCreate_time(time);
			
		
		} else {
			System.out.println("검색결과가 없어요.");
		}
		return bag;

	}
	
	
	
	public ArrayList<BoardVO> selet() throws Exception {
		
		ArrayList<BoardVO> list = new ArrayList();
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector연결 성공.!!");

		String url = "jdbc:mysql://localhost:3366/corona";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공.!!");

		String sql = "select no, title, writer, create_day from board";

		PreparedStatement ps = con.prepareStatement(sql);
		

		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공.!!");
		
		//BoardVO vo = new BoardVO();// 가방만들어서,
		
		
		while (rs.next()) { // 결과가 있는지 없는지 체크해주는 메서드
			BoardVO vo2 = new BoardVO();
			int no1 = rs.getInt(1);
			String title = rs.getString(2);
			String writer = rs.getString(3);
			String date = rs.getString(4);
			

			vo2.setNo(no1);
			vo2.setTitle(title);
			vo2.setWriter(writer);
			vo2.setCreate_date(date);
			
			list.add(vo2);
		}
		return list;

	}
	
	public void delete(String no) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector 성공!!");

		String url = "jdbc:mysql://localhost:3366/corona";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. DB연결 성공");

		String sql = "delete from board where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, no);
		System.out.println("3. SQL문 생성 성공!!");

		ps.executeUpdate();
		System.out.println("4. SQL문 전송 성공!!");

	}

	
	public void update(BoardVO vo) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector연결 성공.!!");

		String url = "jdbc:mysql://localhost:3366/corona?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공.!!");

		String sql = "update board set writer=?, title=?, content=? where no =?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, vo.getWriter());
		ps.setString(2, vo.getTitle());
		ps.setString(3, vo.getContent());
		ps.setString(4, String.valueOf(vo.getNo()));

		ps.executeUpdate();
		System.out.println("성공.!!");

	}
	
	
	
}
