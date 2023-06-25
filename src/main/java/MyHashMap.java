public class MyHashMap {
    private static final int DEFAULT_CAPACITY = 16;
    private Node[] buckets;
    private int size;

    public MyHashMap() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(Object key, Object value) {
        int bucketIndex = getBucketIndex(key);
        Node newNode = new Node(key, value);

        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = newNode;
        } else {
            Node currentNode = buckets[bucketIndex];
            while (currentNode.next != null) {
                if (currentNode.key.equals(key)) {
                    currentNode.value = value;
                    return;
                }
                currentNode = currentNode.next;
            }
            if (currentNode.key.equals(key)) {
                currentNode.value = value;
            } else {
                currentNode.next = newNode;
            }
        }

        size++;
    }

    public void remove(Object key) {
        int bucketIndex = getBucketIndex(key);

        if (buckets[bucketIndex] == null) {
            return;
        }

        Node previousNode = null;
        Node currentNode = buckets[bucketIndex];

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                if (previousNode == null) {
                    buckets[bucketIndex] = currentNode.next;
                } else {
                    previousNode.next = currentNode.next;
                }
                size--;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public void clear() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int bucketIndex = getBucketIndex(key);
        Node currentNode = buckets[bucketIndex];

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }

        return null;
    }

    private int getBucketIndex(Object key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    private static class Node {
        private final Object key;
        private Object value;
        private Node next;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
