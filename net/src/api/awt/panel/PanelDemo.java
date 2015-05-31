package api.awt.panel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Toolkit;

public class PanelDemo {
	public static void main(String[] args) {
		/*
		 * [1] 컴포넌트 생성
		 * */
		Frame frame = new Frame("메모장");
		frame.setSize(500, 300);
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // Toolkit 객체생성
		Dimension dimension = toolkit.getScreenSize(); // 화면크기
		
		Panel panel = new Panel();
		panel.setBackground(Color.GREEN);
		panel.setSize(100, 100);
		panel.setLocation(50,50);
		
		Button ok = new Button("OK");
		
		/*
		 * [2] 컴포넌트 결합
		 * */
		panel.add(ok);
		frame.add(panel);
		
		/*
		 * [3] 컴포넌트 구체화
		 * */
		frame.setLocation(dimension.width/2, dimension.height/2);
		frame.setVisible(true);
	}
}
