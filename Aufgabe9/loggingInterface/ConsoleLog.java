package loggingInterface;

public class ConsoleLog implements Loginterface {

	LogLevel level;

	@Override
	public void setLogLevel(LogLevel level) {
		this.level = level;

	}

	@Override
	public void error(String msg) {
		System.out.println("error: " + msg);
	}

	@Override
	public void warning(String msg) {
		System.out.println("warning: " + msg);
	}

	@Override
	public void debug(String msg) {
		System.out.println("debug: " + msg);
	}

	public void log(String msg) {
		String lvl = level.toString();

		switch (lvl) {
		case "DEBUG":
			debug(msg);
			break;
		case "WARN":
			warning(msg);
			break;
		case "ERROR":
			error(msg);
			break;
		}
	}

}
