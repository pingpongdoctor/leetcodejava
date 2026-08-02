/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 Solution 2 pointers

 2  4   3
            i
 5  6   4
            j

 dummy->7->0->8
              t

6
    i
5
    j

if i and j are null and the carry is 1, add node with value 1 to the dummy

dummy->1

carry = 1

2   8   9   5
            i
3   4
            j

carry = 0

dummy   5   2   0   6

 */

public class Leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode i = l1;
        ListNode j = l2;
        ListNode dummy = new ListNode(0,null);
        ListNode tail = dummy;
        int carry = 0;

        while(i!= null || j!= null) {
            int iVal = i == null ? 0 : i.val;
            int jVal = j == null ? 0 : j.val;
            int sum = iVal + jVal + carry;
            int newVal = sum;

            if(sum >= 10) {
                carry = 1;
                newVal = sum%10;
            } else {
                carry = 0;
            }

            ListNode newNode = new ListNode(newVal, null);
            tail.next = newNode;
            tail = tail.next;

            if(i != null) {
                i = i.next;
            }
            
            if(j != null) {
                j = j.next;
            }
        }

        if(carry == 1) {
            ListNode lastNode = new ListNode(1,null);
            tail.next = lastNode;
        }

        return dummy.next;
    }
}