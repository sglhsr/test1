import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class test {

	public static void main(String[] args) {
		Timer timer=new Timer();
		TimerTask task =new TimerTask() {
			int count=10;
			@Override
			public void run() {
				// TODO Auto-generated method stub
			
				System.out.println("aa");
			}
			
		};
//		timer.schedule(task, 1000);
		Calendar date=Calendar.getInstance();
		date.set(Calendar.DAY_OF_MONTH, 10);
		
		timer.scheduleAtFixedRate(task, 0, 4000);
	}

}
