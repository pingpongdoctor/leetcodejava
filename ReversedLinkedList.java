// 206. Reverse Linked List
//use newHead to gradually form new reversed linkedlist
class ReversedLinkedList {
  class ListNode {
    ListNode next;
    int val;
  }

  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode newHead = new ListNode();
    while (head != null) {
      ListNode temp1 = head;
      head = head.next;
      ListNode temp2 = newHead.next;
      newHead.next = temp1;
      temp1.next = temp2;
    }
    return newHead.next;
  }
}