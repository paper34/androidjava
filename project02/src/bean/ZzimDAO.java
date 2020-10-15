package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dbcp.DBConnectionMgr;

//CRUD중심으로 기능을 정의
//데이터와 관련된 작업(Data Access Object: DAO)
public class ZzimDAO {
	/*
	 * String url =
	 * "jdbc:mysql://localhost:3366/project02?useUnicode=true&characterEncoding=utf8";
	 * String user = "root"; String password = "1234";
	 */

	Connection con;
	DBConnectionMgr dbcp;
	ResultSet rs;

	public ZzimDAO() throws Exception {
		dbcp = DBConnectionMgr.getInstance();

		/*
		 * // 1. connector설정 Class.forName("com.mysql.jdbc.Driver");
		 * System.out.println("1. connector연결 성공.!!");
		 * 
		 * // 2. db연결 con = DriverManager.getConnection(url, user, password);
		 * System.out.println("2. db연결 성공.!!");
		 */
	}

//찜 버튼 클릭시 DB저장 (상품의 name과 회원의 id)
	public boolean zzim(String name, String id) throws Exception {
		con = dbcp.getConnection();
		// 3. sql문을 만든다.(create)
		String sql = "insert into zzim values (?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, id);
		System.out.println("3. SQL생성 성공.!!");

		// 4. sql문은 전송
		int row = ps.executeUpdate();
		boolean result = false;
		if (row == 1) {
			result = true;
		}
		System.out.println("4. SQL문 전송 성공.!!");
		dbcp.freeConnection(con, ps);
		/*
		 * ps.close(); con.close(); db에 insert 한다음에 바로 count를 위한 메서드를 실행시켜야 하므로, close
		 * 하지 않음
		 */
		return result;
	}
 
 //로그인 회원이 해당 여행지 찜 했는지 검색
	public int read(String name, String id) throws Exception {
		con = dbcp.getConnection();
		String sql = "select * from zzim where name = ? and id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, id);
		

		// 4. sql문은 전송
		// select의 결과는 검색결과가 담긴 테이블(항목+내용)
		// 내용에는 없을 수도 있고, 많은 수도 있음.
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공.!!");
		int result = 0;// 없음.
		while(rs.next()) { // 결과가 있는지 없는지 체크해주는 메서드
			// if(rs.next())와 동일함.
			// if문은 rs.next()가 true때만 실행되므로!
			System.out.println("검색결과가 있어요.");
			System.out.println(rs.getString("name"));
			result = 1; // 있음.
		}
		dbcp.freeConnection(con, ps, rs);
		return result;
		// 0이 넘어가면, 검색결과 없음.
		// 1이 넘어가면, 검색결과 있음.
	}
	
// 회원의 아이디로 찜한 여행지 목록 검색함 (검색결과가 여러개임)
	public ArrayList<ZzimVO> read2(String id) throws Exception {
	con = dbcp.getConnection();
	String sql = "select * from zzim where id = ?";
	PreparedStatement ps = con.prepareStatement(sql);
	ArrayList<ZzimVO> list = new ArrayList<ZzimVO>();	
	ps.setString(1, id);

	// 4. sql문은 전송
	// select의 결과는 검색결과가 담긴 테이블(항목+내용)
	// 내용에는 없을 수도 있고, 많은 수도 있음.
	ResultSet rs = ps.executeQuery();
	System.out.println("4. SQL문 전송 성공.!!");
	while(rs.next()) { // 결과가 있는지 없는지 체크해주는 메서드
		ZzimVO vo = new ZzimVO();
		System.out.println(rs.getString("name"));
		vo.setId(rs.getString("id"));
		vo.setName(rs.getString("name"));
		list.add(vo);
		
	}
	return list;
	}	
	

// 여행상품별 찜 버튼 클릭수 카운트 하기 
	public int zzimcount(String name) throws Exception {

		con = dbcp.getConnection();
		String sql = "select count(*) from zzim where name = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, name);

		// 4. sql문은 전송
		// select의 결과는 검색결과가 담긴 테이블(항목+내용)
		// 내용에는 없을 수도 있고, 많은 수도 있음.
		ResultSet rs = ps.executeQuery(); // rs
		System.out.println("4. SQL문 전송 성공.!!");

		int count = 0;// 없음.
		if (rs.next()) { // 결과가 있는지 없는지 체크해주는 메서드
			count = rs.getInt(1);
			System.out.println("검색결과" + count + "개");

		} else {
			System.out.println("검색결과가 없어요.");
		}

		dbcp.freeConnection(con, ps, rs);
		return count;
	}

// 버튼 중복클릭시 찜한여행지 취소(삭제)
	public boolean delete(String name, String id) throws Exception {
		con = dbcp.getConnection();
		// 3. sql문을 만든다.(create)
		String sql = "delete from zzim where name = ? and id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, id);

		// 4. sql문은 전송

		int row = ps.executeUpdate();
		boolean result = false;
		if (row == 1) {
			result = true;
		}

		dbcp.freeConnection(con, ps);
		return result;
	}

}