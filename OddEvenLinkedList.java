// 328. Odd Even Linked List
// use two new heads to from two new linkedlist then connect them to generate new sorted linkedlist
class Solution {
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

  public ListNode oddEvenList(ListNode head) {
    ListNode newHead1 = new ListNode();
    ListNode newHead2 = new ListNode();
    ListNode new1 = newHead1;
    ListNode new2 = newHead2;
    ListNode p = head;
    int i = 1;
    while (p != null) {
      if (i % 2 != 0) {
        ListNode temp = p;
        p = p.next;
        new1.next = temp;
        new1 = temp;
        new1.next = null;
      } else {
        ListNode temp = p;
        p = p.next;
        new2.next = temp;
        new2 = temp;
        new2.next = null;
      }
      i++;
    }
    new1.next = newHead2.next;
    return newHead1.next;
  }
}