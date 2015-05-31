package api.awt.button;

import java.awt.Button;
import java.awt.Frame;

public class ButtonDemo {
	public static void main(String[] args) {
		Frame frame = new Frame("프레임 + 버튼");
		frame.setSize(300, 200);
		frame.setLayout(null); 
		/*
		 * 레이아웃 설정 메소드를 null 로 해야
		 * 버튼이 프레임과 일치하게 나타나지 않음
		 * */ 
		
		Button button = new  Button("확인");
		button.setSize(100,50);  // 크기
		button.setLocation(100, 75); // 위치
		
		frame.add(button);
		frame.setVisible(true);
		
		/*
		한글깨짐 대응
		properties 
		> run/debug settings 
		> ButtonDemo 더블클릭 
		> arguments 탭 클릭
		> VM arguments 빈공간에
		> -Dfile.encoding=MS949 입력
		> 저장후 재실행
		 * */
		
	}
}
