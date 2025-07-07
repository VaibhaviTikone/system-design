import Constants.LogLevel;
import LogObserver.LogSinkSubject;
import Logger.LogHandler;

public class Logger {
    private final static Logger loggerInstance = new Logger();
    private static final LogHandler loghandler = LogManager.buildLoggerChain();
    private final static LogSinkSubject sinkSubject = LogManager.buildLogSinkSubject();

    private Logger() {}

    public static Logger getLoggerInstance() {
        return loggerInstance;
    }

    private void logMessage(String message, LogLevel level) {
        loghandler.log(message, level, sinkSubject);
    }

    public void info(String message) {
        logMessage(message, LogLevel.INFO);
    }

    public void error(String message) {
        logMessage(message, LogLevel.ERROR);
    }

    public void debug(String message) {
        logMessage(message, LogLevel.DEBUG);
    }
}
