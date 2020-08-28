package 클래스만들기;

import 클래스사용하기.게시판작성;

public class 게시판 {

	public static void main(String[] args) {
		
		게시판작성 bod1 = new 게시판작성();
		bod1.id = 1;
		bod1.title = "java";
		bod1.content = "fun java";
		bod1.writer = "park";
		
		System.out.println("id " + "title " + "content " + "writer ");
		System.out.println("--------------------------");
		System.out.println(bod1);
		
		게시판작성 bod2 = new 게시판작성();
		bod2.id = 2;
		bod2.title = "jsp";
		bod2.content = " fun jsp";
		bod2.writer = " kim";
		System.out.println(bod2);
		
		
	}

}
