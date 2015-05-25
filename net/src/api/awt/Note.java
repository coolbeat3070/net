package api.awt;
import   java.awt.*;
import   java.awt.event.*;

public class Note extends  Frame {
	private  TextArea  ta = new TextArea( );
	private  Font font = new Font("궁서체", Font.BOLD, 36 );
	
	public Note( ){
		//Frame에  add대상을 ta
		ta.setFont(font);
		this.add(ta);
		
		//화면윈도우모양크기 만들기
		this.setTitle("메모장");
		this.setBackground(Color.GREEN);//바탕칼라
		this.setBounds(100, 100, 600, 450);//x,y,가로,높이
		this.setVisible(true);//진짜창=화면 보여주기
		
		//감시자=>윈도우감시자
		MyExit me = new MyExit( ); //아래문장은익명의개체로 접근
		this.addWindowListener(new MyExit( ));
	}//생성자end
	
	public static void main(String[] args) {//static=정적함수
		new Note( );//개체이름이 없어요 annoymous
	} //end
	
	class MyExit  extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			System.out.println("내부클래스 프로그램을 종료합니다");
			System.exit(1);//진짜종료처리 Terminates the currently Running JVM
		}		
	}//내부클래스 end
} //class END======================================================================


