// 86. Partition List
// Using two pointers is more complex since we need to handle the edge case where pre pointer can move faster than cur pointer
// Best solution which is found more readable is using two different lists. One list contains nodes with smaller values than x and the other list has bigger values
// Merge two list to form the final list
public class PartitionList {
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

  public ListNode partition(ListNode head, int x) {
    ListNode small = new ListNode();
    ListNode big = new ListNode();
    ListNode s = small;
    ListNode b = big;

    while (head != null) {
      if (head.val < x) {
        s.next = head;
        s = s.next;
      } else {
        b.next = head;
        b = b.next;
      }
      head = head.next;
    }

    big = big.next;
    s.next = big;
    b.next = null;

    return small.next;
  }
}