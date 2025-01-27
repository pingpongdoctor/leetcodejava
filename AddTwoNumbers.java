// 2. Add Two Numbers
// Traverse two linked lists and calculate the sum of corresponding nodes then add the carry-over from previous addition
// Save the carry-over for the next calculation
class AddTwoNumbers {
  class ListNode {
    ListNode next;
    int val;

    public ListNode() {
    }

    public ListNode(int val) {
      this.val = val;
    }
  }

  public ListNode AddNumbers(ListNode l1, ListNode l2) {
    ListNode p1 = l1;
    ListNode p2 = l2;
    ListNode dummyNode = new ListNode();
    ListNode p3 = dummyNode;
    int save = 0;
    while (p1 != null && p2 != null) {
      int val1 = p1.val;
      int val2 = p2.val;
      int rs = val1 + val2 + save;
      int rm = rs % 10;
      save = rs / 10;
      ListNode newNode = new ListNode(rm);
      p3.next = newNode;
      p3 = p3.next;
      p1 = p1.next;
      p2 = p2.next;
    }
    while (p1 != null) {
      int val = p1.val;
      int rs = val + save;
      int rm = rs % 10;
      save = rs / 10;
      ListNode newNode = new ListNode(rm);
      p3.next = newNode;
      p3 = p3.next;
      p1 = p1.next;
    }
    while (p2 != null) {
      int val = p2.val;
      int rs = val + save;
      int rm = rs % 10;
      save = rs / 10;
      ListNode newNode = new ListNode(rm);
      p3.next = newNode;
      p3 = p3.next;
      p2 = p2.next;
    }
    if (save > 0) {
      ListNode newNode = new ListNode(save);
      p3.next = newNode;
    }
    return dummyNode.next;
  }
}