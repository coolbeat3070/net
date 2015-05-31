package api.awt.font;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Toolkit;

public class FontDemo {
	public static void main(String[] args) {
		/*
		 * [1] 컴포넌트 생성
		 * */
		Frame frame = new Frame("메모장");
		frame.setSize(500, 300);
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // Toolkit 객체생성
		Dimension dimension = toolkit.getScreenSize(); // 화면크기
		
		Label labTest = new Label(" Hello AWT !!");
		labTest.setBounds(50,50,30,10); // 50.50 위치에 가로 30 세로 10
	
		Font plain = new Font("Serif",Font.PLAIN,20);
		Font italic = new Font("Serif",Font.ITALIC,20);
		Font bold = new Font("Serif",Font.BOLD,20);
		Font boldItalic = new Font("Serif",Font.BOLD+Font.ITALIC,20);
		
		/*
		 * [2] 컴포넌트 결합
		 * */
		labTest.setFont(boldItalic);
		frame.setLayout(new FlowLayout());
		frame.add(labTest);

		
		
		/*
		 * [3] 컴포넌트 구체화
		 * */
		frame.setLocation(dimension.width/2, dimension.height/2);
		// 화면을 가운데로 두는 소스
		// frame.setLocation(dimension.width/2-150, dimension.height/2-100);  약간 값을 수정
		frame.setVisible(true);
	}
}
