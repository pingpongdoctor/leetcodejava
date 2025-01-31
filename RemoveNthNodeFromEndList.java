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
    ;
    bf.next = bf.next.next;
    return dummyNode.next;
  }

  // Two pointers
  public ListNode removeNthFromEnd2(ListNode head, int n) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode dummyNode = new ListNode();
    dummyNode.next = head;
    ListNode slow = dummyNode;
    ListNode fast = dummyNode;

    while (n > 0) {
      fast = fast.next;
      n--;
    }
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }
    slow.next = slow.next.next;
    return dummyNode.next;
  }
}