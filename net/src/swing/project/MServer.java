package swing.project;

import java.io.*;
import java.net.*;
import java.util.*;  //벡터를 사용
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MServer extends JFrame implements Runnable, ActionListener{  //������ ���
	Vector vc=new Vector();
	TextArea ta = new TextArea();;
	JButton jbexit = new JButton("��������");

	public MServer() {
		super("����");
		this.add(ta,"Center");
		this.add(jbexit,"South");
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(50,100,300,600);
		jbexit.addActionListener(this);
	}//end

	public void run(){
		ServerSocket ss=null;
		try{
			ss=new ServerSocket(5555);  //�������� ��� �����ϴ� ��Ʈ��ȣ(����� ��Ʈ)
		}catch(Exception ex){System.out.println("����:"+ex); return;}
		while(true){
			try{
				ta.append("Ŭ���̾�Ʈ ���Ӵ����\n"); //������� ��� ���� ������ Ŭ���̾�Ʈ����߿��� �����ϸ� accept()�� �ް� ������ ������ ��
				Socket s=ss.accept();  //���� ������ ����. ������ ����(���� ������ Ŭ���̾�Ʈ�� ����)
				//Ŭ���̾�Ʈ���� ���ӿ䱸�� ������ �̸� ���ϰ�ü�� �Ҵ��ϰ�, �Ҵ�� ���ϰ�ü�� 
				//���� ������ ����ϰ� �Ǵ� ������ ���´�. �̸� ���� accept() ���
				ta.append("Ŭ���̾�Ʈ ����ó�� \n");

				Service cs=new Service(s);  //(��ü ��� ��������� �ʼ�). Ŭ���̾�Ʈ�κ��� �޽����� �׻� �ް�, ���� �� �ֵ��� �ι�° �����带 ������ ����Ŭ������ �����.
				cs.start();   //run() �޼ҵ� ȣ��
				cs.myname=cs.in.readLine();
				cs.messageAll("/c"+cs.myname); //Ŭ���̾�Ʈ�� �̸��� ��� Ŭ���̾�Ʈ���� �ѷ� ���������� �˸���. �ֳĸ� /c��ȭ���� ����� �Ǵϱ� �ϴ� ���常 �˸��°���.
				vc.add(cs); //�̹� ���ӵǾ� �ִ� �ٸ� Ŭ���̾�Ʈ���� ���� �˸��� ���� ���Ϳ� ���

				for(int i=0;i<vc.size();i++){
					Service cs1=(Service)vc.elementAt(i); //���� ��� ������
					cs.message("/c"+cs1.myname); //myname�� ������ Ŭ���̾�Ʈ�� �޽��� �ѷ��ֱ�
					//���� ������ ���... ������ ������ �����;���.
				}
			}catch(Exception ex){ex.printStackTrace(); return;}
		}//while end
	} //run�޼ҵ� end

	class Service extends Thread{  //����Ŭ����...Run()�޼ҵ� ������. �̸��̳� /n�� ���� ��ɾ�, �޽����� �ް� �Ѹ��� �����ε�...
		String myname="guest";   //��ȭ��
		BufferedReader in;
		OutputStream out;
		Socket s;
		
		Calendar now=Calendar.getInstance();

		public Service(Socket s){
			try{
				this.s=s;  //����� Ŭ���̾�Ʈ�� ���� ���� ���� ��
				in=new BufferedReader(new InputStreamReader(s.getInputStream())); //Ŭ���̾�Ʈ���� ������ ��Ʈ������ �о ������ ��.
				//InputStreamReader�� in�� s�� �ٸ� ����.
				out=s.getOutputStream(); //Ŭ���̾�Ʈ���� ���� ������ �ٽ� Ŭ���̾�Ʈ�� ������ ���� OutputStream(),��, �ѷ��� ������ ������ �ִ�
			}
			catch(Exception ex){ex.printStackTrace(); return;}
		}//end

		public void run(){
			while(true){
				try{
					String msg=in.readLine(); //��ȭ�� �Ǵ� �޼��� ����. ����ؼ� ������
					ta.append("���� : " + msg + "\n");
					if(msg==null) return;
					if(msg.charAt(0)=='/'){
						if(msg.charAt(1)=='n'){ // /n:�̸��ٲٱ�, /i:�ӼӸ�, /t:��
							if(msg.charAt(2)==' '){
								messageAll("/n"+myname+"-"+msg.substring(3).trim());
								//���� "-"�� ���б�ȣ(������), ���߿� client���� myname�� ���̸��� �и��ϱ� ����
								this.myname=msg.substring(3).trim();
							}
						}
						else if(msg.charAt(1)=='q'){ //Ŭ���̾�Ʈ�� ����������...
							try{
								for(int i=0 ; i<vc.size(); i++){
									Service  svc = (Service)vc.get(i);
									if(myname.equals(svc.myname)){
										vc.remove(i);
										break;
									}
								}
								messageAll("/q"+myname);

								in.close();
								out.close();
								s.close();  //���� ����
								return;
							}catch(Exception ex){messageAll("/q"+myname);}
						}
						else if(msg.charAt(1)=='s'){
							String name=msg.substring(2, msg.indexOf('-')).trim();
							for(int i=0;i<vc.size();i++){
								Service cs3=(Service)vc.elementAt(i);
								if(name.equals(cs3.myname)){
									cs3.message(myname+">>(�ӼӸ�)"+msg.substring(msg.indexOf('-')+1));
									break;
								}
							} //for end
						} //else if
					}//if end
					else
						messageAll(myname+">"+msg);  //��ȭ���message
				}catch(Exception ex){ex.printStackTrace(); return;}
			}//while end
		}//run end

		public void messageAll(String msg){  
			//������ �ڷ� ������ Ŭ���̾�Ʈ���� ������
			for(int i=0;i<vc.size();i++){
				try{
					Service cs=(Service)vc.elementAt(i); //i��° ���Ͱ����� �Ʒ�ó�� �Ѹ���
					cs.message(msg);
				}catch(Exception ex){vc.removeElementAt(i--);} //���ܹ߻�� ����
			}   
		}//messageAll end

		public void message(String msg) throws Exception{
			//������ Ŭ���̾�Ʈ�� ������ �����ִ� �޼ҵ�
			out.write((msg+"\n").getBytes());
			ta.append("���� : " + msg + "\n");
		}//message end
	}//ServiceŬ���� end

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbexit)
			System.exit(0);
	}//end 

	public static void main(String[] args){
		MServer cs=new MServer();
		new Thread(cs).start();  //Thread t=new Thread(cs); t.start()�� ����
	}//main end
} //class END