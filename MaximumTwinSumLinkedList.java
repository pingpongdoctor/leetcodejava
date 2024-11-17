import java.util.ArrayList;
import java.util.List;

//2130. Maximum Twin Sum of a Linked List
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

  // arraylist solution
  public int pairSum(ListNode head) {
    if (head.next.next == null) {
      return head.val + head.next.val;
    }
    List<Integer> list = new ArrayList<>();
    while (head != null) {
      list.add(head.val);
      head = head.next;
    }
    int L = 0;
    int R = list.size() - 1;
    int maxSum = Integer.MIN_VALUE;
    while (L <= R) {
      maxSum = Math.max(maxSum, list.get(L) + list.get(R));
      L++;
      R--;
    }
    return maxSum;
  }

  // fast and slow solution
  public int pairSum2(ListNode head) {
    if (head.next.next == null) {
      return head.val + head.next.val;
    }
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode prev = null;
    while (slow != null) {
      ListNode next = slow.next;
      slow.next = prev;
      prev = slow;
      slow = next;
    }
    int max = Integer.MIN_VALUE;
    while (head != null && prev != null) {
      max = Math.max(max, prev.val + head.val);
      head = head.next;
      prev = prev.next;
    }
    return max;
  }
}