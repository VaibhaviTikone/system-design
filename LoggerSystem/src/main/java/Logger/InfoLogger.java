package Logger;

import Constants.LogLevel;
import LogObserver.LogSinkSubject;

public class InfoLogger extends LogHandler {

    public InfoLogger(LogLevel level) {
        this.loglevel = level;
    }

    public void publishLog(String message, LogSinkSubject logSinkObject) {
        logSinkObject.notifyObservers(loglevel, String.format("INFO: %s", message));
    }
}
