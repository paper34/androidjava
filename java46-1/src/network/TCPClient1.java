package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient1 {
	public static void main(String[] args) throws Exception {

		for (int i = 1; i <= 1000; i++) {
			// 서버와연결
			Socket socket = new Socket("localhost", 9100); // server와 연결 socket?
			System.out.println(i + " 번째 client 서버와 연결됨");
			
			// 서버에서 정보받기
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream())); // server가 보낸 문자 받기
			String data = input.readLine(); // 문자를 string으로 인식
			System.out.println("받은데이터: " + data);
		}
		System.exit(0);
	}
}
