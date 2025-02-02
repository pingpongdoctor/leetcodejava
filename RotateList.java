// 61. Rotate List
// Convert list to cycle list and find the distance to get to the node that should be the head using len - k%len
class RotateList {
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

    public ListNode rotateRight(ListNode head, int k) {
      if (head == null || head.next == null) {
        return head;
      }
      ListNode p = head;
      int len = 1;
      while (p != null && p.next != null) {
        p = p.next;
        len++;
      }

      p.next = head;
      int len2 = len - k % len;
      for (int i = 0; i < len2; i++) {
        if (i == len2 - 1) {
          ListNode temp = head.next;
          head.next = null;
          head = temp;
        } else {
          head = head.next;
        }

      }

      return head;
    }
  }
}