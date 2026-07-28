/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 Questions:
 Can the list be empty?
 Is it sorted?
 Are the values integer?

 Solution 1: Two pointers. We traverse the list and track the prev and cur nodes using two pointers. The temp node is set to the first node. By comparing the cur and temp, we can find the duplicates

     1->2->3->null
           p    c

temp = 3;

Time On(n)
Space O(1)

Test
1   2   3
        p
            c

temp = 3;
 */
public class Leetcode83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        int temp = head.val;
        ListNode pre = head;
        ListNode cur = head.next;

        while(cur != null) {
            if(temp != cur.val) {
                temp = cur.val;
                pre = pre.next;
                cur = cur.next;
            } else {
                cur = cur.next;
                pre.next = cur;
            }
        }

        return head;
    }
}