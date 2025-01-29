// 21. Merge Two Sorted Lists
public class MergeTwoSortedLists {
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

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummyNode = new ListNode();
    ListNode p = dummyNode;
    ListNode p1 = list1;
    ListNode p2 = list2;
    while (p1 != null && p2 != null) {
      if (p1.val >= p2.val) {
        p.next = p2;
        p2 = p2.next;
      } else {
        p.next = p1;
        p1 = p1.next;
      }
      p = p.next;
    }
    while (p1 != null) {
      p.next = p1;
      p1 = p1.next;
      p = p.next;
    }
    while (p2 != null) {
      p.next = p2;
      p2 = p2.next;
      p = p.next;
    }
    return dummyNode.next;
  }
}