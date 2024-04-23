package seleniumadvanceproject;

import org.apache.logging.log4j.*;

public class DemoLog4j 
{
    //to use log4j jar first we need to create a logger object via using log manager API ,in this class
	
	private static Logger log = LogManager.getLogger(DemoLog4j.class.getName());		
	
	public static void main(String[] args) 
	{
		
	 // now we can use this "log" object for printing various logs in output as shown below like.. error,fatal,info,debug etc
		log.info("error is present");
	    log.debug("I m debugging");
	  
	    if (9>8)
		  
		  log.error("this is wrong");
	      log.fatal("its an fatal error");

	}

}
