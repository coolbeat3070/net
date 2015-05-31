package api.awt.label;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Toolkit;

public class LabelDemo {
	public static void main(String[] args) {
		Frame frame = new Frame("메모장");
		frame.setSize(500, 300);
		frame.setLayout(null); // 내부 구성원과의 일체화 제거
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // Toolkit 객체생성
		Dimension dimension = toolkit.getScreenSize(); // 화면크기
		
		Label labId = new Label(" ID :");
		labId.setBounds(50,50,30,10); // 50.50 위치에 가로 30 세로 10
				
		Label labPwd = new Label(" Password :");
		labPwd.setBounds(50,65,100,10);
		
		
		frame.add(labId);
		frame.add(labPwd);

		
		
		// 화면을 가운데로 두는 소스
		frame.setLocation(dimension.width/2, dimension.height/2);
		// frame.setLocation(dimension.width/2-150, dimension.height/2-100);  약간 값을 수정
		frame.setVisible(true);
	}
}
