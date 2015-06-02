package swing;
/*시스아웃만 찍히고 모양은 안보임 - 실패*/
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingCalcDemo {
	public static void main(String[] args) {
		SwingCalcDemo m = new SwingCalcDemo();
		
		System.out.println("lll");
	}

	class YouPanel extends JPanel {
		private static final long serialVersionUID = 1L;
			BufferedImage img = null;
			int img_x = 50, img_y = 50;
			
			public  YouPanel( ){
				try {
					img = ImageIO.read(new File("img\\kuma.gif"));
					this.setBackground(Color.green) ;
				} catch (IOException e) {
					System.out.println("IOException.....");
					System.exit(1);
				}
		
		addKeyListener(new KeyListener() { 
			public void keyPressed(KeyEvent e) {
				int keycode = e.getKeyCode();
				switch (keycode) {
				case KeyEvent.VK_UP:	img_y -= 10;	 break;
				case KeyEvent.VK_DOWN:	img_y += 10;	break;
				case KeyEvent.VK_LEFT:	img_x -= 10; if( img_x<=-30){ img_x=350;}	break;
				case KeyEvent.VK_RIGHT:	img_x += 10; if( img_x>=360){ img_x=-10;}	break;
				}
				repaint(); // paint(Graphics g) => repaint() 메소드로 호출
				// 진짜 메소드 호출 대신 다른 메소드 이름으로 호출
			}
			public void keyReleased(KeyEvent arg0) {		}
			public void keyTyped(KeyEvent arg0) {			}

	});
	this.requestFocus();
	setFocusable(true);
	}
	
	public void paintComponent(Graphics g) {
			super.paintComponent(g);
			String pos="x=" + img_x  +"  y="+img_y;
			g.drawString(pos, 10,30);
			g.drawImage(img, img_x, img_y, null);
		}
	}

	class CarGameTest  extends JFrame {
		private static final long serialVersionUID = 1L;
		public CarGameTest() {
			init();
		}
		public void init(){
			setBounds(200,200,400, 300);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			add(new YouPanel());
			setVisible(true);
		}
	
	
			
	} //class END
	class WindowEventEx extends Frame implements WindowListener{
		private static final long serialVersionUID = 1L;

		public WindowEventEx(){
			super("WindowEvent TEST");
			Label exitL = new Label("Please press close button !!");
			add(exitL);
			
			setBounds(300,300,200,200);
			setVisible(true);
			addWindowListener(this);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

	}
	
}
