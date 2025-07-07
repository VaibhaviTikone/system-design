package Logger;

import Constants.LogLevel;
import LogObserver.LogSinkSubject;

public class ErrorLogger extends LogHandler {
    public ErrorLogger(LogLevel level) {
        this.loglevel = level;
    }
    @Override
    public void publishLog(String message, LogSinkSubject logSinkObject) {
        logSinkObject.notifyObservers(loglevel, String.format("ERROR: %s", message));
    }
}
