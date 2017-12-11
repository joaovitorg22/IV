package com.meuempregado.bean;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.meuempregado.service.ImpostoEmpregadoService;

public class CalcularImpostosEmpregadoMB extends TimerTask implements ServletContextListener{

	Calendar date = Calendar.getInstance();
	Timer timer = new Timer();
	
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		int day = date.getTime().getDate();
		int month = date.getTime().getMonth();
		if(day>14)
			month++;
		
		date.set(Calendar.MONTH, month);
	    date.set(Calendar.DAY_OF_MONTH, 13);
	    date.set(Calendar.HOUR, 1);
	    date.set(Calendar.MINUTE, 0);
	    date.set(Calendar.SECOND, 0);
	    
	    
	    timer.schedule(
	      new CalcularImpostosEmpregadoMB(),
	      date.getTime(),
	      1000*60*60*24
	    );
	}

	
	 @Override
		public void run() {
			
		 	new ImpostoEmpregadoService().calcularImpostos();

		}


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
