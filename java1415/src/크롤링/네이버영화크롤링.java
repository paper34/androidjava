package 크롤링;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class 네이버영화크롤링 {

	public static void main(String[] args) {

		// 1번
		Connection con = Jsoup.connect("https://movie.naver.com/movie/bi/mi/basic.nhn?code=190010#");

		// 2번
		try {
			Document doc = con.get();
			
			// 3번
			Elements list = doc.select("dd > p > a");
			System.out.println(list.size());
			System.out.println(list.get(0).text());
			

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
