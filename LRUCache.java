import java.util.HashMap;
import java.util.Map;

// 146. LRU Cache
// Using map to store nodes
// Using a doubly linked list to track LRU (least recently used) nodes
class LRUCache {
  class Node {
    int val;
    int key;
    Node next;
    Node prev;

    Node() {
    };

    Node(int key, int val) {
      this.val = val;
      this.key = key;
    };
  }

  int cap;
  Node head;
  Node tail;
  Map<Integer, Node> map;

  public LRUCache(int capacity) {
    this.cap = capacity;
    head = new Node(-1, -1);
    tail = new Node(-1, -1);
    head.next = tail;
    tail.prev = head;
    map = new HashMap<>();
  }

  private void addToHead(Node cur) {
    cur.next = head.next;
    head.next.prev = cur;
    head.next = cur;
    cur.prev = head;
  }

  private void deleteNode(Node cur) {
    cur.prev.next = cur.next;
    cur.next.prev = cur.prev;
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    // move the node to the place right after the head
    // now it becomes the most used
    Node cur = map.get(key);
    deleteNode(cur);
    addToHead(cur);
    return cur.val;
  }

  public void put(int key, int value) {
    if (!map.containsKey(key)) {
      Node newNode = new Node(key, value);
      map.put(key, newNode);
      addToHead(newNode);
      if (cap == 0) {
        Node lastNode = tail.prev;
        map.remove(lastNode.key);
        deleteNode(lastNode);
      } else {
        cap--;
      }
    } else {
      Node cur = map.get(key);
      cur.val = value;
      deleteNode(cur);
      addToHead(cur);
    }
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */