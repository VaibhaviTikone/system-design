import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApplication {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread producer = new Thread(resource::produce);
        Thread consumer = new Thread(resource::consume);
        consumer.start();
        producer.start();
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        try (AutoCloseable closeable = threadPool::shutdown) {
            for (int i = 0; i < 5; i++) {
                threadPool.submit(() -> System.out.println("Running task..."));
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
