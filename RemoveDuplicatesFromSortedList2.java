// 82. Remove Duplicates from Sorted List II
// Two pointers solution
// One pointer points to the node that are for sure not duplicate
// Another pointer traverse the list to look for the duplicate nodes by comparing current node and next node
public class RemoveDuplicatesFromSortedList2 {
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

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode dummyNode = new ListNode(101);
    ListNode p1 = dummyNode;
    dummyNode.next = head;
    ListNode p2 = head;

    while (p2 != null && p2.next != null) {
      if (p2.val != p2.next.val) {
        ListNode temp = p2;
        p2 = p2.next;
        p1 = temp;
      } else {
        while (p2.next != null && p2.val == p2.next.val) {
          p2 = p2.next;
        }
        ListNode temp2 = p2.next;
        p1.next = temp2;
        p2 = temp2;
      }
    }
    return dummyNode.next;
  }
}
