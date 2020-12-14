package network;

import java.net.InetAddress;

//  domain name : www.naver.com
//  DNS(domain,범위 name system) 서버     ==> IP 주소


public class DomainToIP {

	public static void main(String[] args) throws Exception {
		String domain = "www.kakao.com";
		
		InetAddress ip = InetAddress.getByName(domain);
		
		System.out.println("ip주소:" + ip.getHostAddress());
	}

}
