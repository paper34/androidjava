package dbcp;

public class ConDAO {
	static ConDAO con;

	public static ConDAO getInstance() {
		if (con == null) {
			con = new ConDAO();
		}
		return con;
	}
}
