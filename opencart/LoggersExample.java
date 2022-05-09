package opencart;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Appender; 

import org.apache.log4j.ConsoleAppender; 

import org.apache.log4j.Layout; 

import org.apache.log4j.Logger; 

import org.apache.log4j.SimpleLayout; 

import org.apache.log4j.HTMLLayout; 


public class LoggersExample {

	

	private static Logger log=Logger.getLogger(LoggersExample.class); 

	public static void main(String[] args) { 


	Layout layout=new SimpleLayout(); 

	Appender app=new ConsoleAppender(layout); 

	log.addAppender(app); 
	}
}

	 
	 

