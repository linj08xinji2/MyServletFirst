package logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoggerTest {
	private static Log logger = LogFactory.getLog(LoggerTest.class);
	
	// ¼Ójar°ü
	public static void main(String[] args) {
		logger.debug("this is debug");
		logger.error("this is error");
		logger.info(" this is info");
		logger.warn(" this is warn");
		logger.fatal(" this is fatal");
		logger.trace(" this is trace");
		System.out.println("end");
	}
} 
