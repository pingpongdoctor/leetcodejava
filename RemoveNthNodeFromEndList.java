import java.util.HashMap;
import java.util.Map;

// 19. Remove Nth Node From End of List
public class RemoveNthNodeFromEndList {
  class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  // Map solution
  public ListNode removeNthFromEnd(ListNode head, int n) {
    Map<Integer, ListNode> map = new HashMap<>();
    ListNode dummyNode = new ListNode();
    dummyNode.next = head;
    ListNode p = dummyNode;
    int i = 0;

    while (p != null) {
      map.put(i, p);
      p = p.next;
      i++;
    }
    int idx = i - n;
    ListNode bf = map.get(idx - 1);
    ListNode af = map.get(idx + 1);
    bf.next = af;
    return dummyNode.next;
  }
}