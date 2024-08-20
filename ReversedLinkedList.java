
class ReversedLinkedList {
  class ListNode {
    ListNode next;
    int val;
  }
  public ListNode reverseList(ListNode head) {
      if(head==null){
          return head;
      }
      ListNode newHead = null;
      while (head!=null){
          ListNode next = head.next;
          head.next = newHead;
          newHead=head;
          head=next;
      }
      return newHead;
  }
}