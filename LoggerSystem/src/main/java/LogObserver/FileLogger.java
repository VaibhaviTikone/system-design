package LogObserver;

public class FileLogger implements LogObserver {
    @Override
    public void log(String message) {
        System.out.println("Logging to file: " + message);
    }
}
