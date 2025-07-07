package LogObserver;

public class DatabaseLogger implements LogObserver {
    @Override
    public void log(String message) {
        System.out.println("Logging to Database: " + message);
    }
}
