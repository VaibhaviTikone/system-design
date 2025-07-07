package Logger;

import Constants.LogLevel;
import LogObserver.LogSinkSubject;

public abstract class LogHandler {
    public LogHandler logger;
    public LogLevel loglevel;

    public void setLogger(LogHandler logger) {
        this.logger = logger;
    }

    public void log(String message, LogLevel level, LogSinkSubject logSinkObject) {
        //System.out.println("level received" + level);
        if(this.loglevel.equals(level)) {
            publishLog(message, logSinkObject);
        }
        if(logger != null) {
            logger.log(message, level, logSinkObject);
        }
    }

    public abstract void  publishLog(String message, LogSinkSubject logSinkObject);
}
