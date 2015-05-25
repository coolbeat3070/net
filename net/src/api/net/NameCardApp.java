package api.net;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NameCardApp {
	public static void main(String[] args) {
		NameCard m = new NameCard();
	//	m.new WindowEventEx();
	//	m.new CarGameTest();
	
	}
	
}

class NameCard extends JFrame{
	BufferedImage img = null;
	   public NameCard() {
	      
	      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      this.setTitle("네임카드");
	    /*  try{
	      img=ImageIO.read(new File("image/증명사진.jpg"));
	    
	      }catch(IOException e){
	      System.out.println(e.getMessage());
	      System.exit(0);
	      }*/
	      setSize(500,360);
	     
	     
	      add(new myPanel());
	      setVisible(true);
	     
	   }
class myPanel extends JPanel{
	  
	  public void paint(Graphics g){
	   g.drawImage(img,0,0,null);
	   g.drawString("이름:1001146 방석민입니다",300,160);
	   g.drawString("전공:MGC_A",300,200);
	   
	  }
	 }
}
