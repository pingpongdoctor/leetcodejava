/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }

Solution 1: Move the slow pointer one step and the fast pointer two steps. If they ever point to the same node, a cycle exists. If the fast pointer reaches null, the list ends, so there is no cycle. Since the fast pointer moves two nodes each iteration, after moving it one step we must check whether it became null. Otherwise, we can get the NullPointerException.

 3  2   0   -4
            s
            f

Time O(n)
Space (O1)
 */

public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;

            if(fast == null) {
                return false;
            }

            fast = fast.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }
}