package loggingInterface;

public class Main {

	public static void main(String[] args) {
		ConsoleLog logger = new ConsoleLog();
		
		logger.setLogLevel(LogLevel.WARN);
		logger.log("Warning");

	}

}
