package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import dbcp.DBConnectionMgr;

public class ItemDAO {
	Connection con;
	DBConnectionMgr dbcp;
	
	public ItemDAO() throws Exception {
		dbcp = DBConnectionMgr.getInstance();
	}
	
	public int create (ItemVO vo) throws Exception {
		con = dbcp.getConnection();
		String query = "insert into item value (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, vo.getName());
		ps.setString(2, vo.getText());
		ps.setString(3, vo.getAddress());
		ps.setString(4, vo.getTel());
		ps.setString(5, vo.getLat());
		ps.setString(6, vo.getLng());
		ps.setString(7, vo.getTag());
		ps.setString(8, vo.getKeyword());
		int result = -1;
		
		result = ps.executeUpdate();

		dbcp.freeConnection(con, ps);
		return result;
	}
	
	public Vector<ItemVO> read (String categoryName) throws Exception {
		con = dbcp.getConnection();
		Vector<ItemVO> bag = new Vector<ItemVO>();
		String query = "select * from item";
		if(!categoryName.equals("")) query = query.concat(" where tag = ?");
		PreparedStatement ps = con.prepareStatement(query);
		if(!categoryName.equals("")) ps.setString(1, categoryName);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			ItemVO vo = new ItemVO();
			vo.setName(rs.getString("name"));
			vo.setLikes(rs.getInt("likes"));
			bag.add(vo);
		}
		dbcp.freeConnection(con, ps, rs);
		return bag;
	}
	
	public ItemVO one (String name) throws Exception {
		con = dbcp.getConnection();
		String query = "select * from item where name = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		ItemVO vo = null;
		if(rs.next()) {
			vo = new ItemVO();
			vo.setName(name);
			vo.setText(rs.getString("text"));
			vo.setAddress(rs.getString("address"));
			vo.setTel(rs.getString("tel"));
			vo.setLat(rs.getString("lat"));
			vo.setLng(rs.getString("lng"));
			vo.setKeyword(rs.getString("keywords"));
			vo.setTag(rs.getString("tag"));
			vo.setLikes(rs.getInt("likes"));
		}
		dbcp.freeConnection(con, ps, rs);
		return vo;
	}
		
	public int view (String name) throws Exception {
		con = dbcp.getConnection();
		String query = "select * from item where name = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		int result = 0;
		if(rs.next()) {
			result = rs.getInt("view");
		}
		result++;
		query = "update item set `view` = ? where `name` = ?";
		ps = con.prepareStatement(query);
		ps.setInt(1, result);
		ps.setString(2, name);
		ps.executeUpdate();
		dbcp.freeConnection(con, ps, rs);
		return result;
	}

	public int likes (String name) throws Exception {
		con = dbcp.getConnection();
		String query = "select * from item where name = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		int result = 0;
		if(rs.next()) {
			result = rs.getInt("likes");
		}
		result++;
		query = "update item set `likes` = ? where `name` = ?";
		ps = con.prepareStatement(query);
		ps.setInt(1, result);
		ps.setString(2, name);
		int ret = ps.executeUpdate();
		dbcp.freeConnection(con, ps, rs);
		return result;
	}
}
