package db연결;

import java.util.ArrayList;

public class 게시판전체 {

	public static void main(String[] args) throws Exception {
	      BbsDAO dao = new BbsDAO();
	      ArrayList<BbsVO> list = dao.all();
	      System.out.println("게시판의 개수: " + list.size() + "개");
	      for (int i = 0; i < list.size(); i++) {//5
	         BbsVO bag = list.get(i);
	         System.out.println("NO: " + bag.getNo());
	         System.out.println("TITLE: " + bag.getTitle());
	         System.out.println("CONTENT: " + bag.getContent());
	         System.out.println("WRITER: " + bag.getWriter());
	         System.out.println();
	      }
	   }


}
