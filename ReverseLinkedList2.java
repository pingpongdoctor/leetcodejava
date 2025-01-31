// 92. Reverse Linked List II
public class ReverseLinkedList2 {
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

  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode dummyNode = new ListNode();
    dummyNode.next = head;
    ListNode prev = dummyNode;
    for (int i = 0; i < left - 1; i++) {
      prev = prev.next;
    }
    ListNode cur = prev.next;

    for (int j = 0; j < right - left; j++) {
      ListNode temp = cur.next;
      cur.next = temp.next;
      temp.next = prev.next;
      prev.next = temp;
    }

    return dummyNode.next;
  }
}