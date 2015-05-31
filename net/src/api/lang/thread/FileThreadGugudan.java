package api.lang.thread;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileThreadGugudan implements Runnable{
	@Override
	public void run() {
		int num=0;
		while(true){
			num++;
			try{
				Thread.sleep(500);
			}catch(Exception ex){
				
			}
			System.out.print(num+"\t");
			if(((num%5)==0)){
				System.out.println();
			}
			
			else if(num==20){
				break;
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
		new Thread(new FileThreadGugudan()).start(); 
		System.out.println("단입력");
		Scanner sc = new Scanner(System.in);
		int dan=1;
		dan = sc.nextInt();
		
		try {
			File file = new File("c:"+File.separator+"myFolder");
			if(!file.exists()){
				file.mkdir();
			}
			File txt = new File("c:"+File.separator+"myFolder"+File.separator+"gugudan.txt");
			PrintWriter pw = new PrintWriter(txt);
			for(int i=0;i<10;i++){
			//  pw.print(dan+"*"+i+"="+(dan*i));
				pw.printf("%d * %d = %d\t",dan ,i ,dan*i);
				pw.println("");
				if(i==5)break;
			}
			System.out.println("저장성공!!");
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
