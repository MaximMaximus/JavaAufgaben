package loggingLog4j;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {

	public static void main(String[] args) {
		Logger logger = Logger.getRootLogger();
		PropertyConfigurator.configure("log4j.properties");
		
		// unkommentieren um durch Programm festzulegen
		// kommentieren um durch properties festzulegen
		//logger.setLevel(Level.TRACE);
		
		logger.debug("Meine Debug-Meldung");
		logger.info("Meine Info-Meldung");
		logger.warn("Meine Warn-Meldung");
		logger.error("Meine Error-Meldung");
		logger.fatal("Meine Fatal-Meldung");

	}

}
