import java.util.Scanner;

public class LRUCacheApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter capacity: ");
        int capacity = scanner.nextInt();
        LRUCache lruCache = new LRUCache(capacity);
        System.out.println("GET");
        System.out.println("Enter operations: put key value or get key");
        System.out.println("Enter exit for closing the application");
        while(true) {
            String line = scanner.nextLine().trim();
            if(line.equalsIgnoreCase("exit")) break;
            String[] tokens = line.split(" ");
            if(tokens.length ==0) continue;
            String operation = tokens[0].toLowerCase();
            switch (operation) {
                case "get":
                    if (tokens.length !=2) {
                        System.out.println("Invalid inputs");
                        break;
                    }
                    int key = Integer.parseInt(tokens[1]);
                    int value = lruCache.get(key);
                    System.out.println(" GET: key "+ key + " -> " + value);
                    break;
                case "put":
                    if(tokens.length != 3) {
                        System.out.println("Invalid inputs");
                        break;
                    }
                    key = Integer.parseInt(tokens[1]);
                    value = Integer.parseInt(tokens[2]);
                    lruCache.put(key, value);
                    System.out.println("PUT successful");
                    break;
                default:
                    System.out.println("Invalid operation: " + operation);
            }
        }
        scanner.close();
        System.out.println("LRU cache session ended.");
    }

}
