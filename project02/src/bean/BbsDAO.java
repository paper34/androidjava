package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dbcp.DBConnectionMgr;

public class BbsDAO {
	Connection con;
	DBConnectionMgr dbcp;
	ResultSet rs;

	public BbsDAO() throws Exception {
		dbcp = DBConnectionMgr.getInstance();
		System.out.println("1. db연결 성공.!!");

	}

	public int getNext() throws Exception{
		con = dbcp.getConnection();
		String SQL = "select no from board ORDER BY no DESC";
		PreparedStatement pstmt;
		pstmt = con.prepareStatement(SQL);
		rs = pstmt.executeQuery();
		int result = 1;
		if (rs.next()) {
			result = rs.getInt(1) + 1;
		}
		dbcp.freeConnection(con, pstmt, rs);
		return result;
	}

	// 게시판 글 작성
	public void create(BbsVO vo) throws Exception {

		con = dbcp.getConnection();

		// 3. sql문을 만든다.(create)
		String sql = "insert into board values (?,?,?,?,now(),now(),0,1)";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, getNext());
		ps.setString(2, vo.getTitle());
		ps.setString(3, vo.getWriter());
		ps.setString(4, vo.getContent());
		// ps.setDate(4, vo.getDay());
		// ps.setTime(5, vo.getTime());

		System.out.println("3. SQL생성 성공.!!");

		// 4. sql문은 전송
		ps.executeUpdate();

		System.out.println("4. SQL문 전송 성공.!!");

		dbcp.freeConnection(con, ps);

	}

	// 게시물 상세보기
	public BbsVO one(int no) throws Exception {

		con = dbcp.getConnection();

		// 3. sql문을 만든다.
		String sql = "select * from board where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);

		// 4. sql문은 전송
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공.!!");
		BbsVO bag = new BbsVO();// 가방만들어서,

		if (rs.next()) { // 결과가 있는지 없는지 체크해주는 메서드
			bag.setNo(rs.getInt("no"));
			bag.setTitle(rs.getString("title"));
			bag.setWriter(rs.getString("writer"));
			bag.setContent(rs.getString("content"));
			bag.setDay(rs.getDate("day"));
			bag.setTime(rs.getTime("time"));
			bag.setCount(rs.getInt("count"));
		}
		dbcp.freeConnection(con, ps, rs);
		return bag;
	}

	

	// 수정
	public boolean update(BbsVO vo) throws Exception {

		con = dbcp.getConnection();

		// 3. sql문을 만든다.(create)
		String sql = "update board set title = ?, content = ? where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, vo.getTitle());
		ps.setString(2, vo.getContent());
		ps.setInt(3, vo.getNo());
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

	// 게시물 삭제
	public boolean delete(int no) throws Exception {

		con = dbcp.getConnection();

		// 3. sql문을 만든다.(create)
		String sql = "delete from board where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
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

	// 조회수 업데이트
	public boolean count_up(BbsVO vo) throws Exception {

		con = dbcp.getConnection();

		// 3. sql문을 만든다.(create)
		String sql = "update board set count=count+1 where no = ?"; // 게시글번호 기준으로 count + 1 씩 해주는 sql
		
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, vo.getNo());
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
	
	// 전체 목록 리스트
	public ArrayList<BbsVO> getList(int pageNumber) throws Exception {
		con = dbcp.getConnection();
		String sql = "select * from board where no < ? and bbsAvailable = 1 ORDER BY no DESC LIMIT 11";
		ArrayList<BbsVO> list = new ArrayList<BbsVO>();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, getNext() - (pageNumber - 1) * 10);
		rs = ps.executeQuery();
		while (rs.next()) {
			BbsVO bbs = new BbsVO();
			bbs.setNo(rs.getInt("no"));
			bbs.setTitle(rs.getString("title"));
			bbs.setWriter(rs.getString("writer"));
			bbs.setContent(rs.getString("content"));
			bbs.setDay(rs.getDate("day"));
			bbs.setCount(rs.getInt("count"));
			bbs.setBbsAvailable(rs.getInt("bbsAvailable"));
			list.add(bbs);
		}
		
		dbcp.freeConnection(con, ps, rs);
		return list;
	}
	
	// 제목 검색
	public ArrayList<BbsVO> search(int pageNumber, String title) throws Exception {
		con = dbcp.getConnection();
		String sql = "select * from board where title like '%" + title + "%' and no < ? and bbsAvailable = 1 ORDER BY no DESC LIMIT 11";
		ArrayList<BbsVO> list = new ArrayList<BbsVO>();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, getNext() - (pageNumber - 1) * 10);
		rs = ps.executeQuery();
		while (rs.next()) {
			BbsVO bbs = new BbsVO();
			bbs.setNo(rs.getInt("no"));
			bbs.setTitle(rs.getString("title"));
			bbs.setWriter(rs.getString("writer"));
			bbs.setContent(rs.getString("content"));
			bbs.setDay(rs.getDate("day"));
			bbs.setCount(rs.getInt("count"));
			bbs.setBbsAvailable(rs.getInt("bbsAvailable"));
			list.add(bbs);
		}
		dbcp.freeConnection(con, ps, rs);
		return list;
	}
	
	// 다음 페이지
	public boolean nextPage(int pageNumber) throws Exception {
		con = dbcp.getConnection();
		String SQL = "SELECT * FROM board WHERE no < ? AND bbsAvailable = 1 ";
		ArrayList<BbsVO> list = new ArrayList<BbsVO>();
		PreparedStatement pstmt = con.prepareStatement(SQL);
		pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			return true;

		}
		dbcp.freeConnection(con, pstmt, rs);
		return false;
	}

}
