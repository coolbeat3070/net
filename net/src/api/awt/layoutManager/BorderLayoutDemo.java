package api.awt.layoutManager;
/*
 * Frame 의 기본 Layout 은 border layout 이다.
 * Panel 의 기본 Layout 은 flow layout 이다.
 * */
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.io.ObjectInputStream.GetField;

public class BorderLayoutDemo {
	public static void main(String[] args) {
		/*
		 * [1] 컴포넌트 생성
		 * */
		Frame frame = new Frame("메모장");
		frame.setSize(500, 400);
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // Toolkit 객체생성
		Dimension dimension = toolkit.getScreenSize(); // 화면크기
		frame.setLayout(new BorderLayout());
		
		
		Panel north = new Panel();
		north.setBackground(Color.GREEN);
		north.setPreferredSize(new Dimension(500,100));
		north.add(new Label("North"));
		
		Panel center = new Panel();
		center.setBackground(Color.YELLOW);
		center.setPreferredSize(new Dimension(300,200));
		center.add(new Label("Center"));
		
		Panel east = new Panel();
		east.setBackground(Color.BLUE);
		east.setPreferredSize(new Dimension(100,200));
		east.add(new Label("East"));
		
		Panel west = new Panel();
		west.setBackground(Color.BLUE);
		west.setPreferredSize(new Dimension(100,200));
		west.add(new Label("West"));
		
		Panel south = new Panel();
		south.setBackground(Color.RED);
		south.setPreferredSize(new Dimension(500,100));
		south.add(new Label("South"));
		
		
		/*
		 * [2] 컴포넌트 결합
		 * */
		frame.add(center,BorderLayout.CENTER);
		frame.add(north,BorderLayout.NORTH);
		frame.add(south,BorderLayout.SOUTH);
		frame.add(east,BorderLayout.EAST);
		frame.add(west,BorderLayout.WEST);
		
		/*
		 * [3] 컴포넌트 구체화
		 * */
		frame.setLocation(dimension.width/2, dimension.height/2);
		frame.setVisible(true);
	}
}
