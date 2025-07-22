import java.util.HashMap;

public class LRUCache {
    private final int capacity;
    private HashMap<Integer, LLNode> llMap = new HashMap<>();
    private LLNode head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LLNode(0,0);
        tail = new LLNode(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value) {
        if(llMap.containsKey(key)) {
            remove(llMap.get(key));
        }
        LLNode node = new LLNode(key, value);
        llMap.put(key, node);
        insert(node);
        if(llMap.size() >capacity) {
            remove(head.next);
            llMap.remove(head.next.key);
        }
    }

    public int get(int key) {
        if (llMap.isEmpty() || !llMap.containsKey(key)) return -1;
        LLNode node = llMap.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    private void insert(LLNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    private void remove(LLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
