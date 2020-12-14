package dbcp;

public class singleTonTest2 {

	public static void main(String[] args) {
		ConDAO con = ConDAO.getInstance();
		System.out.println(con);
		ConDAO con2 = ConDAO.getInstance();
		System.out.println(con2);
		ConDAO con3 = ConDAO.getInstance();
		System.out.println(con3);
		ConDAO con4 = ConDAO.getInstance();
		System.out.println(con4);
		ConDAO con5 = ConDAO.getInstance();
		System.out.println(con5);

	}

}
