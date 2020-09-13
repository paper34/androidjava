package 크롤링;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class 코로나크롤링 {

	public static void main(String[] args) {
		// 1번
		Connection con = Jsoup.connect("http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=11&ncvContSeq=&contSeq=&board_id=&gubun=");
		// 2번
		
		try {
			Document doc = con.get();
			// 3번
			Elements list = doc.select("dd");
			Elements list2 = list.select(".inner_value");
			
			System.out.println(list2.size());
			
			for (int i = 0; i < list2.size(); i++) {
				String 누적 = list2.get(i).text();
				System.out.println(누적);
				
			}
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
