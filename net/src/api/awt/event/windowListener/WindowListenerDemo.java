package api.awt.event.windowListener;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListenerDemo {
	public static void main(String[] args) {
		/*
		 * [1] 컴포넌트 생성
		 * */
		Frame frame = new Frame("메모장");
		frame.setSize(500, 300);
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // Toolkit 객체생성
		Dimension dimension = toolkit.getScreenSize(); // 화면크기
		
		
		
		/*
		 * [2] 컴포넌트 구체화
		 * */
		frame.setLocation(dimension.width/2, dimension.height/2); 
		// frame.setLocation(dimension.width/2-150, dimension.height/2-100);  
		// 화면을 가운데로 두는 소스
		frame.addWindowListener(new EventHandler());
		// 이벤트를 결합시킴
		frame.setVisible(true);
	}
}
class EventHandler implements WindowListener{

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// 윈도우 닫기 버튼을 눌렸을 때 호출
		e.getWindow().setVisible(false);
		e.getWindow().dispose();
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
