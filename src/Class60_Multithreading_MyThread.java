
public class Class60_Multithreading_MyThread extends Thread{
	@Override
	public void run() {
		for (int i=10;i>1;i--) {
			System.out.println("Thread #1 : "+ i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Thread1 is finished");
	}
}
