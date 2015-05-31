package api.awt.textField;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;

public class TextFieldDemo {
	public static void main(String[] args) {
		Frame frame = new Frame("메모장");
		frame.setSize(500, 300);
		frame.setLayout(new FlowLayout()); // LayoutManager 을 FlowLayout 을 설정
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // Toolkit 객체생성
		Dimension dimension = toolkit.getScreenSize(); // 화면크기
		
		Label labId = new Label(" ID :");
		labId.setBounds(50,50,30,10); // 50.50 위치에 가로 30 세로 10
				
		Label labPwd = new Label(" Password :");
		labPwd.setBounds(50,65,100,10);
		
		TextField txtId = new TextField(10); // 10개의 글자수까지 가능
		TextField txtPwd = new TextField(10);
		txtPwd.setEchoChar('*'); // 비번이라서 입력값 암호화
		
		
		frame.add(labId);
		frame.add(labPwd);
		frame.add(txtId);
		frame.add(txtPwd);
		
		
		// 화면을 가운데로 두는 소스
		frame.setLocation(dimension.width/2, dimension.height/2);
		// frame.setLocation(dimension.width/2-150, dimension.height/2-100);  약간 값을 수정
		frame.setVisible(true);
		
		/*
		 * 카피해서 바로 복붙하면 TextField 가 보이지 않는다.
		 * new FlowLayout() 을 setLayout() 에 설정해야한다.
		 * 위로 덮어쓰기 때문이다.
		 * */
	}
}
