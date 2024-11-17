// 2095. Delete the Middle Node of a Linked List
// use dummy node pointing to head node and prev pointer pointing to dummy
// use fast and slow pointer to find the middle node then point prev node to slow.next node

public class DeleteMiddleNodeLinkedList {
  public class ListNode {
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

  class Solution {
    public ListNode deleteMiddle(ListNode head) {
      if (head == null || head.next == null) {
        return null;
      }
      ListNode dummy = new ListNode();
      dummy.next = head;
      ListNode fast = head;
      ListNode slow = head;
      ListNode prev = dummy;
      while (fast != null && fast.next != null) {
        prev = prev.next;
        slow = slow.next;
        fast = fast.next.next;
      }
      prev.next = slow.next;
      return head;
    }
  }
}
