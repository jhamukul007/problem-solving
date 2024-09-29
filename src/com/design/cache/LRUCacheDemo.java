public class LRUCache {

    private Map<Integer, DoublyLinkedList<Integer, Integer>> cache;
    private DoublyLinkedList<Integer, Integer> recentlyUsed;
    private DoublyLinkedList<Integer, Integer> leastUsed;
    int capacity;

    public LRUCache(int size) {
        this.cache = new HashMap<>();
        this.capacity = size;
        recentlyUsed = new DoublyLinkedList<>(-1, -1);
        leastUsed = new DoublyLinkedList<>(-1, -1);
        leastUsed.next = recentlyUsed;
        recentlyUsed.prev = leastUsed;
    }

    public void put(int key, int value) {
        DoublyLinkedList<Integer, Integer> existedData = cache.get(key);
        DoublyLinkedList<Integer, Integer> newNode = getNode(key, value);
        if (existedData == null) {
            // Not existed add
            if (cache.size() < capacity) {
                // Add node in last and insert into cache
                insertLastAndCache(newNode);
            } else {
                // Cache is already full evict least recant used key and insert new key value pair into cache.
                DoublyLinkedList<Integer, Integer> evictedNode = evict();
                cache.remove(evictedNode.key);
                insertLastAndCache(newNode);
            }
        }
        else {
            // If key already exist, delete the existing key from
            deleteNode(existedData);
            insertLastAndCache(newNode);
        }
    }

    public int get(int key) {
        DoublyLinkedList<Integer, Integer> existedData = cache.get(key);
        if (existedData == null) {
            return -1;
        }
        deleteNode(existedData);
        insertLastAndCache(existedData);
        return existedData.value;
    }

    private void insertLastAndCache(DoublyLinkedList<Integer, Integer> newNode) {
        DoublyLinkedList<Integer, Integer> prevNode = recentlyUsed.prev;
        prevNode.next = newNode;
        newNode.prev = prevNode;

        newNode.next = recentlyUsed;
        recentlyUsed.prev = newNode;

        // Adding into Cache
        cache.put(newNode.key, newNode);
    }

    private DoublyLinkedList<Integer, Integer> evict() {
        if (leastUsed.next == recentlyUsed)
            return null;
        DoublyLinkedList<Integer, Integer> evictedNode = leastUsed.next;
        leastUsed.next = evictedNode.next;
        evictedNode.next.prev = leastUsed;
        return evictedNode;
    }

    private void deleteNode(DoublyLinkedList<Integer, Integer> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public DoublyLinkedList<Integer, Integer> getNode(int key, int value) {
        DoublyLinkedList<Integer, Integer> newNode = new DoublyLinkedList<>(key, value);
        return newNode;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
    }
}

class DoublyLinkedList<K, V> {

    public DoublyLinkedList<K, V> next;
    public DoublyLinkedList<K, V> prev;
    public K key;
    public V value;

    public DoublyLinkedList(K key, V value) {
        this.prev = null;
        this.next = null;
        this.key = key;
        this.value = value;
    }
}
