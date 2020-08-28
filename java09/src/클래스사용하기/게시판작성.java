package 클래스사용하기;

public class 게시판작성 {
	
	public int  id;
	public String title;
	public String content;
	public String writer;
	
	
	@Override
	public String toString() {
		return id + "  " + title + "  " + content + "  " + writer + "  ";
	}
	
	
	
}
