package Logger;

import Constants.LogLevel;
import LogObserver.LogSinkSubject;

public class DebugLogger extends LogHandler {
    public DebugLogger(LogLevel level) {
        this.loglevel = level;
    }

    @Override
    public void publishLog(String message, LogSinkSubject logSinkObject) {
        logSinkObject.notifyObservers(loglevel, String.format("DEBUG: %s", message));
    }
}
