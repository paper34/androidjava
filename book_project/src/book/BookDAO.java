package book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dbcp.DBConnectionMgr;

public class BookDAO {
	Connection con;
	DBConnectionMgr dbcp;
	ResultSet rs;

	public BookDAO() throws Exception {
		dbcp = DBConnectionMgr.getInstance();
		System.out.println("1. db연결 성공.!!");

	}
	
		public boolean create(BookDTO vo) throws Exception {
			con = dbcp.getConnection();
			
			// 3. sql문을 만든다.(create)
			String sql = "insert into book_product values (null,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			//ps.setInt(1, vo.getId());
			ps.setString(1, vo.getBook_name());
			ps.setString(2, vo.getBook_plot());
			ps.setString(3, vo.getBook_publisher());
			ps.setString(4, vo.getBook_writer());
			
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