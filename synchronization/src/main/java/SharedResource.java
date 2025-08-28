public class SharedResource {
    private boolean ready = false;
     synchronized void produce() {
         try {
             while(ready) {
                 wait();
             }
             System.out.println("Producing");
             ready = true;
             notify();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }

    synchronized void consume() {
         try {
             while(!ready) {
                 wait();
             }
             System.out.println("Consuming");
             ready= false;
             notify();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
    }
}
