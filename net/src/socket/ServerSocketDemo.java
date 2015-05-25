package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {
	public static void main(String[] args) {
		ServerSocketDemo m = new ServerSocketDemo();
		
		try {
			ServerSocket ssk = new ServerSocket(5555);
			Socket sk = ssk.accept();
			Class outClass = Class.forName("Service");
			Object o = outClass.newInstance();
			Service svc = (Service) o;
			
			
			// get ipaddress
			InetAddress ip = sk.getInetAddress();
			
			// byte -> char 
			InputStream is = sk.getInputStream();
			OutputStream os = sk.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
			PrintWriter pw = new PrintWriter(os);
			
			String data="",page="";
			while(true){
				data = br.readLine();
				if(br.equals("q")||br.equals("Q")||br==null){break;}
				System.out.println("내용 >>>:"+data);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	class Service{

		public Service(Socket sk) {
			// TODO Auto-generated constructor stub
		}
		void getTest(){
			System.out.println("테스트");
		}
	}
}
