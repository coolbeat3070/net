package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingDemo {
	public static void main(String[] args) {
		MyFrame f = new MyFrame();
	}
	
}
class MyFrame extends JFrame { // JFrame을 상속받은 MyFrame클래스
	/* 생성자에서 초기화후 프레임 생성(최상위 컨테이너) */
	public MyFrame() { 
		setSize(600, 150); // 프레임 크기 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MVC 모델"); // 프레임 제목 설정
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // Toolkit 객체생성
		Dimension dimension = toolkit.getScreenSize(); // 화면크기
		/* 패널 객체 생성  */
		JPanel panel = new JPanel();
		JPanel panelA = new JPanel();
		JPanel panelB = new JPanel();
		/* 패널 색상 변경 */
		panel.setBackground(Color.YELLOW);
		panelA.setBackground(Color.YELLOW);
		panelB.setBackground(Color.YELLOW);
		/* 라벨 객체 생성, panelA에 label추가 */
		JLabel label = new JLabel ("JEE (MVC 모델) ");
		panelA.add(label);
		/* 버튼 객체 생성 */
		JButton button1 = new JButton("Model : 순수자바");
		JButton button2 = new JButton("View : JSP");
		JButton button3 = new JButton("Controller : 서블릿");
		JButton button4 = new JButton("(+) Database : DBMS");
		/* panelB에 button1,2,3추가 */
		panelB.add(button1);
		panelB.add(button2);
		panelB.add(button3);
		panelB.add(button4);
		/* panel에 panelA,B추가 */
		panel.add(panelA);
		panel.add(panelB);
		/* 프레임에 panel을 추가 */
		add(panel);
		setLocation(dimension.width/2, dimension.height/2); 
		setVisible(true);
	}
}
