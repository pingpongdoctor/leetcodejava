/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * Ask questions:
Can the list be empty?
Is n always valid?

Solution: Two pointer
Move the first pointer n steps to maintain the gap between two pointers then move two pointers until the fast pointer reaches the last element. Then, the slow pointer will be before the node that should be removed.

n = 2
1->2->3->4->5
      i
            j

When j reach the last element, i is the previous node of the node that needs to be removed since the gap between them has remained n nodes 

Edge case 1: Single node
n = 1
    1->null
    i
    j
return null

Edge case 2: Empty linked list
return null

Edge case 3: if j becomes null after moving n steps, n must be equal to the size of the list, which means nth node is the first node and is the node that should be removed.
n = 3
1->2->3->null
i
          j
head = head.next;
return head

Time O(n)
Space O(1)

Test:
n = 2
1->2->3->5->null
      i
            j
 */
public class Leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) {
            head = null;
            return head;
        }

        ListNode i = head;
        ListNode j = head;

        while(n>0) {
            j = j.next;
            n--;
        }

        if(j==null) {
            head = head.next;
            return head;
        }

        while(j.next != null) {
            i = i.next;
            j = j.next;
        }

        i.next = i.next.next;

        return head;
    }
}