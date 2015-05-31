package api.lang.thread;

public class RunnableImplDemo  {
	public static void main(String[] args) {
		Runnable r = new RunnableImpl();
		/*생성자 Thread(Runnable target)*/
		Thread thr = new Thread(r);
		thr.start();
	}
	

}
class RunnableImpl implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<5;i++){
			/*상속이 아니기때문에 super 사용할 수 없다.*/
			System.out.println(Thread.currentThread().getName());
		}
		
	}
}
