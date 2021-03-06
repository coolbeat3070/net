package api.awt.label;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Toolkit;

public class LabelDemo {
	public static void main(String[] args) {
		/*
		 * [1] 컴포넌트 생성
		 * */
		Frame frame = new Frame("메모장");
		frame.setSize(500, 300);
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // Toolkit 객체생성
		Dimension dimension = toolkit.getScreenSize(); // 화면크기
		
		Label labId = new Label(" ID :");
		labId.setBounds(50,50,30,10); // 50.50 위치에 가로 30 세로 10
		Label labPwd = new Label(" Password :");
		labPwd.setBounds(50,65,100,10);
		
		/*
		 * [2] 컴포넌트 결합
		 * */
		frame.setLayout(new FlowLayout()); 
			// LayoutManager 을 FlowLayout 을 설정
		frame.add(labId);
		frame.add(labPwd);
		
		/*
		 * [3] 컴포넌트 구체화
		 * */
		frame.setLocation(dimension.width/2, dimension.height/2);
		frame.setVisible(true);
	}
}
