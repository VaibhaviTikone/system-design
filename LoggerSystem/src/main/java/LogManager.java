import Constants.LogLevel;
import LogObserver.LogObserver;
import LogObserver.LogSinkSubject;
import Logger.DebugLogger;
import Logger.ErrorLogger;
import Logger.InfoLogger;
import Logger.LogHandler;
import LogObserver.FileLogger;
import LogObserver.ConsoleLogger;
import LogObserver.DatabaseLogger;


public class LogManager {
    public static LogHandler buildLoggerChain() {
        LogHandler infoHandler = new InfoLogger(LogLevel.INFO);
        LogHandler errorHandler = new ErrorLogger(LogLevel.ERROR);
        LogHandler debugHandler = new DebugLogger(LogLevel.DEBUG);
        infoHandler.setLogger(debugHandler);
        debugHandler.setLogger(errorHandler);
        return infoHandler;
    }

    public static LogSinkSubject buildLogSinkSubject() {
        LogSinkSubject logSinkSubject = new LogSinkSubject();
        logSinkSubject.addObserver(LogLevel.INFO, new ConsoleLogger());
        logSinkSubject.addObserver(LogLevel.DEBUG, new DatabaseLogger());
        logSinkSubject.addObserver(LogLevel.ERROR, new FileLogger());
        return logSinkSubject;
    }
}
