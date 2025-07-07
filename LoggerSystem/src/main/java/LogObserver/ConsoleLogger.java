package LogObserver;

public class ConsoleLogger implements LogObserver {
    @Override
    public void log(String message) {
        System.out.println("Logging to Console: " + message);
    }
}
