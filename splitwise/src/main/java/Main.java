public class Main {

    public static void main(String []args) throws InterruptedException {
        SingletonClass object = SingletonClass.getSingletonClass();
        System.out.println(object.hashCode());
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1.equals(s2));
        System.out.println(s1==s2);

        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("acquirred two locks");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("acquirred two locks");
                }
            }
        });


        t1.start();
        //t2.start();
    }
}
