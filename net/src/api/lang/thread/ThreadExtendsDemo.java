package api.lang.thread;

public class ThreadExtendsDemo {
	public static void main(String[] args) {
		ThreadExteds thr = new ThreadExteds();
		thr.start();
	}
}
class ThreadExteds extends Thread{
	@Override
	public void run() {
		for(int i=0;i<5;i++){
			System.out.println(super.getName());
		}
	}
}
