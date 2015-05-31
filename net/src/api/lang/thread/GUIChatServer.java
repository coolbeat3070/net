package api.lang.thread;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUIChatServer extends JFrame implements ActionListener{
	  TextArea txt_list;
	  JButton btn_exit;
	  ServerSocket ss=null;	
	  Vector inwon;    //인원수 카운트
	
	public GUIChatServer() 	{
		super("Chatting Server");
		
		txt_list = new TextArea();
		btn_exit = new JButton("��������");
		
		add(txt_list, "Center");
		add(btn_exit,"South");
		setSize(350,650);
		setVisible(true);
		//이벤트처리-----------------------
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		btn_exit.addActionListener(this);
		inwon=new Vector();   //반드시 serverStart()보다 먼저 작성해야함
		serverStart();         // 그렇지 않으면 NullPointException 발생    
	} //end
	
	public void serverStart() {
		final int PORT=7500;
		try{
			ss=new ServerSocket(PORT);
			System.out.println("ServerSocket start ~~~~");
			txt_list.append("ServerSocket start ~~~~");
			txt_list.setFont(new Font("궁서체", Font.BOLD, 16));
			while(true)	{
				Socket sock=ss.accept();
				String str=sock.getInetAddress().getHostAddress();
				txt_list.append(str);
				//병행처리를 하기위한 클라이언트 객체생성(사용자정의 클래스)
				ChatHandle ch=new ChatHandle(this,sock);
				inwon.add(ch);  //전역변수 Vector inwon;   선언
				ch.start();     //startServer()바로 위에 inwon=new Vector(); 
			}
		}catch(IOException e){	}
	}  //end
	
	public void setMsg(String string) {
		txt_list.append(string);	
	} //end
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn_exit)
			System.exit(0);
	} //end
	
	public static void main(String[] args) {
		new GUIChatServer();
	} //end
} //GUIChatServer class END



class ChatHandle extends Thread {
	GUIChatServer server=null;
	Socket sock=null;
	PrintWriter pw=null;
	BufferedReader br=null;
	
	public ChatHandle(GUIChatServer server, Socket sock)	{
		this.server=server;
		this.sock=sock;
		
		try{
			InputStream is=sock.getInputStream();
			br=new BufferedReader(new InputStreamReader(is));
			
			OutputStream os=sock.getOutputStream();
			pw=new PrintWriter(new OutputStreamWriter(os));
		}catch(IOException e){
			e.printStackTrace();
		}
	} //end
	
	public void run() 	{
		String nickname=null;
		
		try{
			nickname=br.readLine();
			server.setMsg("["+nickname+"]님이 입장 하셨습니다\n");   
			broadcast("["+nickname+"]님이 입장 하셨습니다\n");
			
			//��ȭ����-----------------------------------
			while(true){
				try{
					String text=br.readLine();
					server.setMsg(nickname + ":> " + text +"\n");
					broadcast(nickname + ":> " + text);
				}catch(IOException e){	}
			} //while end
			//대화시작 끝-----------------------------------
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			synchronized (server.inwon) {
				server.inwon.remove(this);
				server.setMsg("["+nickname+"]님이 퇴장 하셨습니다\n");
				broadcast("["+nickname+"]님이 입장 하셨습니다\n");
			}
		}
	} //end
	
	/* 모든 접속자에게  메세지를 보내줌 */
	private void broadcast(String string) {
		synchronized (server.inwon) {   /* 동기화처리 */
			int s=server.inwon.size();     //접속자수
			for(int i=0; i<s; i++){
				ChatHandle ch=(ChatHandle)server.inwon.elementAt(i);
			  server.txt_list.append(string +"\n");
				ch.pw.println(string);
				ch.pw.flush();
			}
		}
	} //end
	
} //ChatHandle class END















