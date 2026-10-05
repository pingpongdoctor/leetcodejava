/**
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[  [2],     [1, 1], [2, 2], [1],  [3, 3], [2],  [4, 4], [1],   [3],   [4]]
[ null,        null, null,   1,     null, -1,      null, -1,    3,      4]
cache
[4,4 3,3]

map is used for accessing the values and keys
double linkedlist is used for tracking which is the least used and most used node. least used on the right and most used on the left


key     value
1           1
2           2

1,1 <-> 2,2

Time Complexity:
get is O(1)
put is O(1)

Space Complexity is O(n) for the whole class
*/
public class Leetcode146 {
    private class Node {
        int key;
        int value;
        Node next;
        Node prev;
        public Node (int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    private HashMap<Integer, Node> map;

    private final int capacity;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if(head.next == tail) {
            return -1;
        }

        if(!map.containsKey(key)) {
            return -1;
        }
        Node current = map.get(key);

        moveToTheFront(current);

        return current.value;
    }

    // head -> <- newNode -> <- tail
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node current = map.get(key);
            current.value = value;

            moveToTheFront(current);
            return;
        }

        Node newNode = new Node(key, value);

        if(map.size() < capacity) {
            addAtTheFront(newNode);
            map.put(key, newNode);
            return;
        }

        int deletedKey = deleteLastNode();

        if(deletedKey != -1) {
            map.remove(deletedKey);
        }

        addAtTheFront(newNode);
        map.put(key, newNode);
    }

    private void addAtTheFront(Node node) {
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }

    private int deleteLastNode() {
        if(map.isEmpty()) {
            return -1;
        }

        int key = tail.prev.key;
        Node temp = tail.prev.prev;
        temp.next = tail;
        tail.prev = temp;

        return key;
    }

    private void moveToTheFront(Node node) {
        Node front = node.prev;
        Node rear = node.next;
        front.next = rear;
        rear.prev = front;

        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */