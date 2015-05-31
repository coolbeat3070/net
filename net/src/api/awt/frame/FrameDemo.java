package api.awt.frame;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

public class FrameDemo {
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
		frame.setVisible(true);
		 
	}
}
