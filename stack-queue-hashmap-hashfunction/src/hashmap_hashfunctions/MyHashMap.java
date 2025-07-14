package hashmap_hashfunctions;

public class MyHashMap {
    private static final int SIZE = 1000;

    // Linked list node
    static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Array of linked list heads (buckets)
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    // Hash function
    private int hash(int key) {
        return key % SIZE;
    }

    // Put key-value pair
    public void put(int key, int value) {
        int index = hash(key);
        Node head = buckets[index];

        // Update value if key exists
        Node curr = head;
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }

        // Insert at head
        Node newNode = new Node(key, value);
        newNode.next = head;
        buckets[index] = newNode;
    }

    // Get value by key
    public int get(int key) {
        int index = hash(key);
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }

        return -1; // Not found
    }

    // Remove key
    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    // For testing
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 10);
        map.put(2, 20);
        System.out.println(map.get(1)); // 10
        System.out.println(map.get(3)); // -1
        map.put(2, 30);
        System.out.println(map.get(2)); // 30
        map.remove(2);
        System.out.println(map.get(2)); // -1
    }
}

