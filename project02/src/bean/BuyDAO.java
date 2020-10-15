package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dbcp.DBConnectionMgr;

public class BuyDAO {
	Connection con;
	DBConnectionMgr dbcp;
	
	public BuyDAO() throws Exception {
		dbcp = DBConnectionMgr.getInstance();
		System.out.println("1. db연결 성공.!!");

	}
	
	// 상품 결제 영수증정보 전송 
	public boolean buy(BuyVO vo) throws Exception {
		con = dbcp.getConnection();
		
		// 3. sql문을 만든다.(create)
		String sql = "insert into buy values (null,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		//ps.setInt(1, vo.getId());
		ps.setString(1, vo.getProduct_name());
		ps.setString(2, vo.getUser_name());
		ps.setString(3, vo.getTel());
		ps.setString(4, vo.getCardNm());
		ps.setString(5, vo.getTotal());
		
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