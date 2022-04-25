//multithreading= Process of executing multiple threads simultaneously
//				  Helps maximum utilization of CPU
//				  Threads are independent, they don't affect the execution of other threads 
//				  An exeception in one thread will not interrupt other threads
//				  useful for serving multiple clients, multiplayer games, or other mutually independent
public class Class60_Multithreading {

	public static void main(String[] args) throws InterruptedException {
		Class60_Multithreading_MyThread thread1 =new Class60_Multithreading_MyThread();
		Class60_Multithreading_MyRunnable runnable1=new Class60_Multithreading_MyRunnable();
		Thread thread2=new Thread(runnable1);
		thread1.setDaemon(true);
		thread2.setDaemon(true);
		thread1.start();
//		thread1.join();  // join: thread1跑完才開始跑thread2
//		thread1.join(2000);  //thread1開始後兩2秒才開始thread2
		thread2.start();

	}

}
