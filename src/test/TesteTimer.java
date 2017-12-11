package test;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;


public class TesteTimer extends TimerTask{
	
	Calendar date = Calendar.getInstance();
	Timer timer = new Timer();
	
	@Test
	public void main() {
		int day = date.getTime().getDate();
		int month = date.getTime().getMonth();
		if(day>13)
			month++;
		
		date.set(Calendar.MONTH, month);
	    date.set(Calendar.DAY_OF_MONTH, 1);
	    date.set(Calendar.HOUR, 0);
	    date.set(Calendar.MINUTE, 1);
	    date.set(Calendar.SECOND, 0);
	    
	    
	    timer.schedule(
	      new TesteTimer(),
	      date.getTime(),
	      1000 * 60 * 60
	    );
	}

	@Override
	public void run() {
		int day = date.getTime().getDay();
		int month = date.getTime().getMonth();
		if(day>1)
			month++;
		
		date.set(Calendar.MONTH,month);
		
		System.out.println("aa");
	}
}
