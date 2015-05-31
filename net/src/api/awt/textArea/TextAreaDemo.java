package api.awt.textArea;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.Toolkit;

public class TextAreaDemo {
	public static void main(String[] args) {
		/*
		 * [1] 컴포넌트 생성
		 * */
		Frame frame = new Frame("메모장");
		frame.setSize(500, 300);
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // Toolkit 객체생성
		Dimension dimension = toolkit.getScreenSize(); // 화면크기
		
		TextArea area = new TextArea("글자입력란..",10,50);
		area.selectAll(); // 입력한 전체 글자를 선택
		
		/*
		 * [2] 컴포넌트 결합
		 * */
		frame.setLayout(new FlowLayout());
		frame.add(area);
		
		
		
		
		/*
		 * [3] 컴포넌트 구체화
		 * */
		frame.setLocation(dimension.width/2, dimension.height/2);
		// 화면을 가운데로 두는 소스
		// frame.setLocation(dimension.width/2-150, dimension.height/2-100);  약간 값을 수정
		frame.setVisible(true);
	}
}
