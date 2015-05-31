package api.awt.layoutManager;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;

public class FlowLayoutDemo {
	public static void main(String[] args) {
		/*
		 * [1] 컴포넌트 생성
		 * */
		Frame frame = new Frame("메모장");
		frame.setSize(500, 400);
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // Toolkit 객체생성
		Dimension dimension = toolkit.getScreenSize(); // 화면크기
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		frame.add(new Button("[첫번째버튼]"));
		frame.add(new Button("[두번째버튼]"));
		frame.add(new Button("[세번째버튼]"));
		frame.add(new Button("[네번째버튼]"));
		frame.add(new Button("[다섯번째버튼]"));
		
		
		
		/*
		 * [2] 컴포넌트 구체화
		 * */
		frame.setLocation(dimension.width/2, dimension.height/2); 
		// frame.setLocation(dimension.width/2-150, dimension.height/2-100);  
		// 화면을 가운데로 두는 소스
		frame.setVisible(true);
	}
}
