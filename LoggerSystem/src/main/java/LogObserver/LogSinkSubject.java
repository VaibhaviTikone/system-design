package LogObserver;

import Constants.LogLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSinkSubject {
    private final Map<LogLevel, List<LogObserver>> observers = new HashMap<>();

    public void addObserver(LogLevel level, LogObserver logObserver) {
        List<LogObserver> observerList = observers.getOrDefault(level, new ArrayList<>());
        observerList.add(logObserver);
        observers.put(level, observerList);
    }

    public void notifyObservers(LogLevel level, String message) {
        for(Map.Entry<LogLevel, List<LogObserver>> entry: observers.entrySet()) {
            if(entry.getKey().equals(level)) {
                entry.getValue().forEach(observers -> observers.log(message));
            }
        }
    }
}
