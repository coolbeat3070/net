package api.awt.frame;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

public class FrameDemo {
	public static void main(String[] args) {
		Frame frame = new Frame("메모장");
		frame.setSize(500, 300);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // Toolkit 객체생성
		Dimension dimension = toolkit.getScreenSize(); // 화면크기
		
		// 화면을 가운데로 두는 소스
		frame.setLocation(dimension.width/2, dimension.height/2);
		// frame.setLocation(dimension.width/2-150, dimension.height/2-100);  약간 값을 수정
		frame.setVisible(true);
	}
}
