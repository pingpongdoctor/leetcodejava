/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 Two pointers: slow pointer move by 1 node at a time while fast pointer move 2 nodes at a time. When the fast pointer is at the last node or it is null, the slow pointer is at the middle node.

Edge case where number of nodes is even
 1  2   3   4   5   6
            s
                        f

Edge case where number of nodes is odd
 1  2   3   4   5
        s
                f

Edge case where the number of nodes is 1 -> return head
Edge case where the number of nodes is 2
1   2
    s
        f
return node 2 which is the second middle node

Time O(n)
Space 0(1)

 */

public class Leetcode876 {
    public ListNode middleNode(ListNode head) {
        if(head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
