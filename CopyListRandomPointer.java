import java.util.HashMap;
import java.util.Map;

// 138. Copy List with Random Pointer
// Use hashmap to create pairs of original nodes and copy nodes then
// Traverse the original linked list to generate relations between nodes using the map
public class CopyListRandomPointer {
  class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  public Node copyRandomList(Node head) {
    Map<Node, Node> map = new HashMap<>();
    Node p1 = head;

    while (p1 != null) {
      map.put(p1, new Node(p1.val));
      p1 = p1.next;
    }

    Node p2 = head;

    while (p2 != null) {
      Node copyNode = map.get(p2);
      copyNode.next = map.get(p2.next);
      copyNode.random = map.get(p2.random);
      p2 = p2.next;
    }

    return map.get(head);
  }
}