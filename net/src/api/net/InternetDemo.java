package api.net;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InternetDemo {
	public static void main(String[] args) {
		InetAddress address;
		try {
			address = InetAddress.getLocalHost();
			System.out.println("로컬컴퓨터 이름 :" + address.getHostName());
			System.out.println("로컬컴퓨터 IP :"+address.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
