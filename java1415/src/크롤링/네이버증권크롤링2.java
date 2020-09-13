package 크롤링;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class 네이버증권크롤링2 {

	public String[] crawl(String code) {
		// 1번
		Connection con = Jsoup.connect("https://finance.naver.com/item/main.nhn?code=" + code);

		String[] result = null;
		// 2번
		try {
			// 1
			Document doc = con.get();
			Elements list = doc.select("h2 > a");
			String name = list.get(0).text();
			System.out.println("회사이름: " + name);
			// 2
			Elements list2 = doc.select("span.code");
			String code2 = list2.get(0).text();
//			System.out.println("회사코드: " + code2);
			// 3
			Elements list3 = doc.select("div.today > p");
			Elements list4 = list3.select(".blind");

			String now = list4.get(0).text(); // 현재가
			String dif = list4.get(1).text(); // 차이
			String percent = list4.get(2).text(); // 증감 비율

//			System.out.println("현재가: " + now);
//			System.out.println("어제와의 차이: " + dif);
//			System.out.println("증감비율: " + percent);

			Elements list5 = doc.select("td");
			Elements list6 = list5.select(".blind");
			String before = list6.get(0).text();
			String high = list6.get(1).text();
//			System.out.println("전일 " + before);
//			System.out.println("고가: " + high);

			result= new String[ ]{name,code,now,dif,percent};
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}
