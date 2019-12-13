package loggingInterface;

public interface Loginterface {
	void setLogLevel(LogLevel level);
	void error(String msg);
	void warning(String msg);
	void debug(String msg);
}
