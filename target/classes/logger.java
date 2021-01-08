package resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class logger {
	
	private static Logger LOG =(Logger) LogManager.getLogger(logger.class);
	static logger log=null;
	
	public static logger getInstance() {
		if(log==null)
		{
			log=new logger();
		}
		return log;
	}
	
	
	public void info(String msg) {
		LOG.info(msg);
	}
	
	public void warn(String msg) {
		LOG.warn(msg);
	}
	
	
	public void debug(String msg) {
		LOG.debug(msg);
	}
	public void error(String msg) {
		LOG.error(msg);
	}
	public void fatal(String msg) {
		LOG.fatal(msg);
	}
}
