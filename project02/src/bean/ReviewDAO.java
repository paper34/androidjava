package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import dbcp.DBConnectionMgr;

public class ReviewDAO {
	Connection con;
	DBConnectionMgr dbcp;

	public ReviewDAO() throws Exception {
		dbcp = DBConnectionMgr.getInstance();
	}
	
	public int create (ReviewVO vo) throws Exception {
		con = dbcp.getConnection();
		String sql = "insert into review value (?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getProduct_name());
		ps.setString(3, vo.getText());
		ps.setString(4, vo.getDate());
		int result = ps.executeUpdate();
		dbcp.freeConnection(con, ps);
		return result;
	}
	
	public Vector<ReviewVO> read(String product_name) throws Exception {
		con = dbcp.getConnection();
		String sql = "select * from review where product_name = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, product_name);
		ResultSet rs = ps.executeQuery();
		
		Vector<ReviewVO> bag = new Vector<>();
		while(rs.next()) {
			ReviewVO vo = new ReviewVO();
			vo.setId(rs.getString("id"));
			vo.setProduct_name(rs.getString("product_name"));
			vo.setText(rs.getString("text"));
			vo.setDate(rs.getString("date"));
			bag.add(vo);
		}
		dbcp.freeConnection(con, ps, rs);
		return bag;
	}
	
	public int count (String product_name) throws Exception {
		con = dbcp.getConnection();
		String sql = "select count(*) from review where product_name = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, product_name);
		ResultSet rs = ps.executeQuery();
		int result = 0;
		if (rs.next()) result = rs.getInt(1);
		dbcp.freeConnection(con, ps, rs);
		return result;
	}
}
