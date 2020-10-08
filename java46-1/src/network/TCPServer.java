package network;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws Exception {
		// 1. 연결 요청만 담당하는 서버용 socket이 필요
		// prototype(프로토타입) 방법 <-> singleton(싱글톤)
		// 필요할때마다 객체 생성 <-> 하나만 객체 생성 주소를 재사용
		ServerSocket server = new ServerSocket(9100); // 서버 open
		System.out.println("TCP 서버 시작됨");
		System.out.println("클라이언트의 요청을 기다리는중...");

		int count = 0; // 카운트
		
		// 서버
		while (true) { // 계속 열기
			Socket socket = server.accept(); // 클라이언트 연결 socket ?
			System.out.println(count + "번: 서버와의 연결 성공.");
			count++;
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // client 에게 문자보내기
			out.println("i am a java programmer!!!");
			
			
		}
	}

}
