package 크롤링;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class 국내크롤링 {

	public static void main(String[] args) {
		// 1번
		Connection con = Jsoup.connect("http://ncov.mohw.go.kr/");

		// 2번
		try {
			Document doc = con.get();
			// 3번
			Elements list = doc.select("li > span.num");

			System.out.println(list.size()); // 갯수
			// 알트 + 쉬프트 + z
			for (int i = 0; i < list.size(); i++) {
				Element tag = list.get(i);
				String text = tag.text();
				System.out.println(text);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
