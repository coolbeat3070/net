package api.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatUserServer {
	public static void main(String[] args) {
		try {
			// 순서1 - 서버소켓 생성 ====> Server생성 ===>먼저실행
			ServerSocket server = new ServerSocket(1111);
			System.out.println(" Server에서 접속 대기중...");

			// 순서2 - 접속한 유저를 허용=수락해서 소켓이 관리
			Socket socket = server.accept();
			// ///////////////소켓이 모든것을 다 관리해요 /////////////////////////

			// 순서3 접속한 주소를 표시 InetAddress이용
			InetAddress add = socket.getInetAddress();
			System.out.println(add + " client접속함 ");

			// 순서4 소켓으로 접속한 InputStream/OutputStream 값 얻어오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			// 순서5 while문을 통해서 소켓으로 받은 입/출력을 char로 주고받게함
			InputStreamReader isr = new InputStreamReader(is); // byte->character
			BufferedReader br = new BufferedReader(isr);// character->text

			while (true) {
				String str = br.readLine();
				if (str == null)
					break;
				System.out.println("client쪽 내용 : " + str);
			} // while END
			br.close();
			socket.close();
		} catch (Exception ex) {
		}
	}// main END
}
