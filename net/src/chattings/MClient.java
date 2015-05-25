package chattings;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MClient extends JFrame implements ActionListener, Runnable, ItemListener {
	JFrame jf=new JFrame("Messenger");
	Canvas cv=new Canvas();
	BufferStrategy bs;
	BufferedImage img = null;
	Choice ch1=new Choice();
	Choice ch2=new Choice();
	JPanel jp1=new JPanel();
	JPanel jp2=new JPanel();
	JPanel jp3=new JPanel();
	JPanel jp4=new JPanel(new BorderLayout());
	JPanel jp5=new JPanel();
	JPanel jp6=new JPanel();
	JPanel jp7=new JPanel();
	JPanel jp8=new JPanel(new BorderLayout());
	JPanel jp9=new JPanel();
	JPanel jp10=new JPanel(new BorderLayout());
	JPanel jp11=new JPanel(new BorderLayout());
	JPanel jp12=new JPanel();
	JPanel jp13=new JPanel();
	JLabel jl_d=new JLabel("��ȭ��");
	TextField tf_name=new TextField(10);
	TextField tf_change=new TextField(10);
	TextField tf_server=new TextField(14);
	TextField tf_msg=new TextField(30);
	JButton jb_con=new JButton("����");
	CheckboxGroup group=new CheckboxGroup();
	Checkbox cb1=new Checkbox("��ο���", group, true);
	Checkbox cb2=new Checkbox("�ӼӸ�", group, false);
	TextArea ta_out=new TextArea(25,1);
	JButton jb_change=new JButton("��ȭ�?��");
	JButton jb_cl=new JButton("���찳");
	JButton jb_send=new JButton("������");
	JButton jb_exit=new JButton("������");
	JLabel jl_ppl=new JLabel("������");
	List list=new List(23);
	JLabel jl_num=new JLabel("�ο��", JLabel.LEFT);
	JLabel num=new JLabel("         ", JLabel.RIGHT);
	JLabel serverip=new JLabel("�����Է�");
	JLabel serverch=new JLabel("��������");
	MenuBar mb=new MenuBar();
	Menu mfile=new Menu("����");
	MenuItem mopen=new MenuItem("�ؽ�Ʈ���� ����");
	MenuItem msave=new MenuItem("��ȭ���� ����");
	MenuItem mexit=new MenuItem("����");
	MenuItem mbb=new MenuItem("���ھ߱�");
	Calendar now;
	String time;
	int hh, mm,  ss;
	int count=0;	
	int ran;
	OutputStream out;
	BufferedReader in;
	Socket soc;

	public MClient(){
		initializeWindow();
		layoutCom();
	}//end

	public void layoutCom() {
		jp1.add(jl_d);
		jp1.add(tf_name);
		jp1.add(jb_con);
		jp1.add(tf_change);
		jp1.add(jb_change);
		jp1.add(cb1);
		jp1.add(cb2);
		jp4.add("North", jp1);
		jp4.add("Center", ta_out);
		jp3.add(jb_cl);
		jp3.add(ch1);
		jp3.add(tf_msg);
		jp3.add(jb_send);
		jp4.add("South", jp3);
		jp9.add(jp4);
		jp5.add(jl_ppl);
		jp8.add("North", jp5);
		for(int i=1; i<20; i++) list.add("");
		jp6.add(list);
		jp8.add("Center", jp6);
		jp7.add(jl_num);
		jp7.add(num);
		jp7.add(jb_exit);
		jp8.add("South",jp7);
		jp12.setBackground(Color.orange);
		jp13.setBackground(Color.orange);
		jp11.add("North",jp12);
		jp11.add("South",jp13);
		jp12.add(serverip);
		jp12.add(tf_server);
		jp13.add(serverch);
		jp13.add(ch2);
		jp10.add("North",jp11);
		jp10.add("South",jp8);
		jf.setMenuBar(mb);
		jf.getContentPane().add("West",jp10);
		jf.getContentPane().add("East", jp9);
		jf.setSize(1190,640);
		jf.setResizable(false);
		mb.add(mfile);
		mfile.add(mopen);
		mfile.add(msave);
		mfile.addSeparator();
		mfile.add(mexit);
		
		ch1.addItem("s(�����)/ ¥��~~");
		ch1.addItem("(*�� .��)a ���!! �ӿ�����?");
		ch1.addItem("��(^0^)~�� ������~ ��ſ�");
		ch1.addItem("��(*�ଥ��)/  ��������!!");
		ch1.addItem("(/��_-)/~ ������!!");
		ch1.addItem("��(- o -) �ѿ�~��!!");
		ch1.addItem("s(�����)v ����~ ��Ĭ!!");
		ch1.addItem("s(���أ� )z ��!! �� ������!");
		ch1.addItem("��(��_ _)�� �ȱ������");
		ch1.addItem("s(��o��)�� ����!! �ָ�!!");
		ch1.addItem("[_]a(^^* ) Ŀ�� ���� �?");
		ch1.addItem("��..�Ѥ� ��̡�");
		ch1.addItem("(::::[ ]::::) ���� ġ�����ٲ�");
		ch1.addItem("(''  )(  '') �丮������");
		ch1.addItem("[(��.��)]zZ ����~~");
		ch1.addItem("[(-.-)(^^*)] ����~ ��?");
		ch1.addItem("O(�����)o �ƽξ�~~");
		ch1.addItem("(^(oo)^) ���� ����");
		ch1.addItem("(T(oo)T) ��� ����");
		ch1.addItem("(-(oo)-) ���� ����");
		ch1.addItem("@-m-m-- �� �޾ƿ�~~");
		ch1.addItem("��(^0^*)/ �̸�ŭ �����!");
		ch1.addItem("��(-0-)/ ������~");
		ch1.addItem("s(�� 3��)��=33 �Ŀ�~ ��� �Ѵ�..");
		ch1.addItem("��(���ң���) �� �ٸ� ����~");
		ch1.addItem("(*^^)/(__ ;) �������� �Ӹ��Դ�");
		ch1.addItem("(*��_(#��_��)_-) ���! ���߽���");
		ch1.addItem("(  ��)=333 �汸 ��~~ ����");
		ch1.addItem("o('-'o) (o'-')o �丮���� ��������");
		
		ch2.addItem("���ְ��� ����");
		ch2.addItem("203.236.209.121");
		ch2.addItem("203.236.209.122");
		ch2.addItem("203.236.209.123");
		ch2.addItem("203.236.209.124");
		
		cv.setSize(400,0);
		jf.getContentPane().add("Center",cv);
		cv.createBufferStrategy(2);
		bs=cv.getBufferStrategy();
		jf.pack();
		jf.setLocationRelativeTo(null);
		
		while(true){
			try{
				random();
				img = ImageIO.read(new File("img"+ran+".jpg"));
			}catch(Exception e){}
			Graphics g = bs.getDrawGraphics();
			g.drawImage(img,WIDTH,HEIGHT,null);
			bs.show();
			try {Thread.sleep(5000);} catch (Exception e) {}
		}
	}//layout end
	
	public void random() {
		for(int i = 0; i < 20; i++){
			ran=(int)(Math.random()*20)+1;
		} //i end
	} //end
	
	public void setList(){ //list �ٽ� �ʱ�ȭ�ϴ� �Լ�
		try{
		for(int i=0; i<20; i++){
			if(list.getItem(i)!=""){
				list.remove(i);
				list.add("", i);
				count--;
			}
		}
		}catch(Exception e){}
	}//end
	
	public void initializeWindow(){
		jf.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){exit();}});
		jp1.setBackground(Color.white);
		jp2.setBackground(Color.white);
		jp3.setBackground(Color.white);
		jp5.setBackground(Color.white);
		jp6.setBackground(Color.white);
		jp7.setBackground(Color.white);
		jp9.setBackground(Color.black);
		jp10.setBackground(Color.black);
		ta_out.setBackground(Color.black);
		ta_out.setFont(new Font("����ü", Font.BOLD, 16));
		list.setFont(new Font("����ü", Font.BOLD, 16));
		tf_server.setFont(new Font("����ü", Font.BOLD, 14));
		ch2.setFont(new Font("����ü", Font.BOLD, 14));
		jf.setResizable(true);
		ta_out.setEditable(true);
		//jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		mexit.addActionListener(this);
		msave.addActionListener(this);
		mopen.addActionListener(this);
		mbb.addActionListener(this);
		jb_exit.addActionListener(this);
		jb_send.addActionListener(this);
		tf_msg.addActionListener(this);
		tf_name.addActionListener(this);
		jb_con.addActionListener(this);
		tf_change.addActionListener(this);
		jb_change.addActionListener(this);
		ta_out.setForeground(Color.white);
		ch1.addItemListener(this);
		ch2.addItemListener(this);
		jb_cl.addActionListener(this);
	}//end

	public void fileSave(){
		FileDialog fd=new FileDialog(this, "��ȭ���� ����", FileDialog.SAVE);
		fd.show();
		String dir=fd.getDirectory();
		String file=fd.getFile();
		if(dir==null||file==null) return;
		File f=new File(dir+file);
		try{
			PrintWriter pw=new PrintWriter(f);
			pw.println(ta_out.getText());
			pw.close();
			ta_out.append("��ȭ������ ����Ǿ���ϴ�\r\n");
		}catch(Exception e){  }
	}//end

	public void fileOpen(){
		FileDialog fd=new FileDialog(this, "���� ����", FileDialog.LOAD);
		fd.show();
		String dir=fd.getDirectory();
		String file=fd.getFile();
		if(dir==null||file==null) return;
		try{
			FileReader fr=new FileReader(dir+file);
			BufferedReader br=new BufferedReader(fr);
			while(true){
				String data="";
				data=br.readLine();
				if(data==null)break;
				//ta_out.append(data+"\n");
				out.write((tf_name.getText()+data+"\n").getBytes());
			}
		}catch(Exception e){  }
	}//end

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mexit || e.getSource()==jb_exit){
			try{
				out.write(("/q"+tf_name.getText()+"\n").getBytes());
				System.out.println("���� : " +tf_name.getText());
				ta_out.append("****"+tf_name.getText()+"���� �����ϼ̽��ϴ�****\r\n");
				in.close();
				out.close();
				soc.close();
				setList();
			}catch(Exception ex ) {
				System.out.println("������ ���� " + ex.getMessage());
			}
			ta_out.setEnabled(false);
			tf_msg.setEnabled(false);
			jb_exit.setEnabled(false);
			tf_name.setEnabled(true);
			jb_con.setEnabled(true);
			tf_name.setText("");
			tf_name.requestFocus();
		}
		else if(e.getSource()==msave){ fileSave(); }
		else if(e.getSource()==mopen){ fileOpen(); }
		else if(e.getSource()==mbb){       }
		else if(e.getSource()==jb_send || e.getSource()==tf_msg){ sendProcess(); }
		else if(e.getSource()==jb_con || e.getSource()==tf_name){ connect(); }
		else if(e.getSource()==jb_change || e.getSource()==tf_change){ change(); }
		else if(e.getSource()==jb_cl){ ta_out.setText(""); }
	}//end
	
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==ch1 && e.getStateChange()==ItemEvent.SELECTED){
			String msg=tf_msg.getText();
			try{
				if(cb1.getState()==true){
					out.write((msg+e.getItem()+"\n").getBytes());
					}
				else if(cb2.getState()==true){
					String name=list.getSelectedItem();
					out.write(("/s"+name+"-"+msg+e.getItem()+"\n").getBytes());
					ta_out.append("(�ӼӸ�)"+name+"�Բ� >> "+msg+e.getItem()+"\r\n");
					}
			}catch(Exception ex){}
			tf_msg.setText("");
			tf_msg.requestFocus();
		}
		if(e.getSource()==ch2 && e.getStateChange()==ItemEvent.SELECTED){
			tf_server.setText("");
			String sv=tf_server.getText();
			try{
				tf_server.setText((sv+e.getItem()));
			}catch(Exception ex){}
			tf_name.requestFocus();
		}
	}//end
	
	public void exit(){
		try{
			out.write(("/q"+tf_name.getText()+"\n").getBytes());
			System.out.println("���� : " +tf_name.getText());
			ta_out.append("****"+tf_name.getText()+"���� �����ϼ̽��ϴ�****\r\n");
			in.close();
			out.close();
			soc.close();
			setList();
		}catch(Exception ex ) {
			System.out.println("������ ���� " + ex.getMessage());
		}
		ta_out.setEnabled(false);
		tf_msg.setEnabled(false);
		jb_exit.setEnabled(false);
		tf_name.setEnabled(true);
		jb_con.setEnabled(true);
		tf_name.setText("");
		tf_name.requestFocus();
		System.exit(1);
	}//end
	
	public void sendProcess(){
		String str=tf_msg.getText();
		try {
			if(str.charAt(0)=='q'){  //q�̸� ���� ����??���� �̰�.....
				out.write(("/q"+tf_name.getText()+"\n").getBytes()); //������ ��ȭ�� ������ in, out, soc �� ����
				System.out.println("������ ���� >> "+tf_name.getText()+" \n");
				in.close();
				out.close();
				soc.close();
				System.exit(0);
			}
			if(cb1.getState()==true){ //��ο��� �޽��� ������
				out.write((tf_msg.getText()+"\n").getBytes());
				System.out.println("�޽����� ������ ���� >> "+tf_msg.getText());
			}
			else if(cb2.getState()==true){ //�ѻ������ �ӼӸ� ������
				try{
					String name=list.getSelectedItem();
					if(name==null || name==""){
						ta_out.append(">>>����� ã�� �� ����ϴ�"+"\r\n");
					}
					else{
					out.write(("/s"+name+"-"+tf_msg.getText()+"\n").getBytes());
					System.out.println("�ӼӸ���� >> /s"+name+"-"+tf_msg.getText());
					ta_out.append("(�ӼӸ�)"+name+"�Բ� >> "+tf_msg.getText()+"\r\n");
					}
				}catch(Exception e){ta_out.append(e.getMessage()); }
			}
			tf_msg.setText("");
			tf_msg.requestFocus();
		} catch (Exception e) { ta_out.append(e.getMessage()); } 
	}//end

	public void connect() { //��ȭ���� ������ ������ �����ڿ� ���. 
		ta_out.setEnabled(true);
		tf_msg.setEnabled(true);
		jb_exit.setEnabled(true);
		try {
			String svip=tf_server.getText();
			soc=new Socket(svip, 5555); //��������
			in=new BufferedReader(new InputStreamReader(soc.getInputStream())); //�������� stream(�����ڵ� �޽��� ���?)�� ������?
			out=soc.getOutputStream(); // ������ ����
			out.write((tf_name.getText()+"\n").getBytes()); //������ ��ȭ���� ����Ʈ���ؼ� ������ ������?
			System.out.println("������ ���� >> "+tf_name.getText()); 
			tf_name.setEnabled(false);
			jb_con.setEnabled(false);
			new Thread(this).start(); //�ٸ� Ŭ���̾�Ʈ���� �޽����� �����κ��� ������
			tf_msg.requestFocus();
		} catch (Exception e) {  ta_out.append(e.getMessage()); }   //���Ͽ��� �߻��� ���ܿ���޽����� ����ϴµ�...
	}//end
	
	public void change(){
			try{
				String msg =tf_change.getText();
				out.write(("/n "+msg+"\n").getBytes());
				tf_change.setText("");
				tf_msg.requestFocus();
			}catch(Exception ex){ }
	}//end

	public void run() {
		while(true){
			now=Calendar.getInstance();
			hh=now.get(now.HOUR_OF_DAY);
			mm=now.get(now.MINUTE);
			ss=now.get(now.SECOND);
			time=hh+":"+mm+":"+ss; 
			//������ �� �޽����� ������, �������� �ٸ� Ŭ���̾�Ʈ���� �޽����� ������
			try {
				String msg = in.readLine();
				System.out.println("�����κ��� ���� : "+msg);

				if(msg==null) return;
				if(msg.charAt(0)=='/'){
					if(msg.charAt(1)=='c'){ //c, s, �̷��� �������� �������ִ°��� 	 
						list.replaceItem(msg.substring(2), count); //list�� msg.substring(2)���� �ְ�, list index�ڸ� ����
						count++;
						num.setText(String.valueOf(count)); //�ο� �� ����
						ta_out.append("****"+msg.substring(2)+"���� �����ϼ̽��ϴ�****\r\n"); //��� Ŭ���̾�Ʈ���� ������ �˸� 
						tf_name.setEnabled(false); //��ȭ�� label ��Ȱ��
						jb_con.setEnabled(false); //���ӹ�ư ��Ȱ��      
					}
					
					else if(msg.charAt(1)=='q'){ //�������ư �����ų� /q�� �Է��ϸ� ������ q�� �Է��� ��. �� �׷��� ����? ����
						String str=msg.substring(2);
						ta_out.append("****"+str+"���� �����ϼ̽��ϴ�****\r\n");
						for(int i=0;i<list.getItemCount();i++){ //list��Ͽ��� �����ϴ� ��ȭ��ã�� ������ remove
							if(str.equals(list.getItem(i))){
								list.remove(i);
								count--;
								num.setText(String.valueOf(count));
								break;
							}
						}
						//return;    �� ������ �������� ������ �ϸ� �� �޽����� �����θ� ���� Ŭ���̾�Ʈ�� �� �ѷ���...
					}
					else if(msg.charAt(1)=='n'){ //��ȭ�?��
						String oldname=msg.substring(2, msg.indexOf('-'));  
						String newname=msg.substring(msg.indexOf('-')+1);
						ta_out.append("*"+oldname+"���� �̸��� "+newname+"���� ����Ǿ���ϴ�.*\r\n");

						for(int j=0;j<count;j++){
							if(oldname.equals(list.getItem(j))){
								list.replaceItem(newname, j);
								break;
							}
						}
					}
				}
				else  ta_out.append("["+time+"] "+msg+"\r\n");
			}catch (Exception e) { ta_out.append(e.getMessage()); } 
		}
	}//end

	public static void main(String[] args) {
		MClient mc=new MClient();
		Thread tr = new Thread(mc);
	}//main end
}//class END