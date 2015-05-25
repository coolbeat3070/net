package api.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatUserClient {

	public static void main(String[] args) throws Exception {
		try {
			// 순서1 ->서버 ip와 포트번호
			Socket socket = new Socket("127.0.0.1", 1111);

			// 순서4 소켓으로 접속한 InputStream/OutputStream 값 얻어오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			// 순서5 while문을 통해서 소켓으로 받은 입/출력을 char로 주고받게함
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
			BufferedReader key = new BufferedReader(new InputStreamReader(
					System.in));
			while (true) {
				System.out.print("메세지: ");
				String data = key.readLine();
				if (data == null)
					break;
				// Client쪽에서 서버로 내용보냄
				pw.println(data);
				pw.flush();
			} // while END
			key.close();
			br.close();
			pw.close();
			socket.close();
		} catch (Exception ex) {
		}
	}// main END
}
