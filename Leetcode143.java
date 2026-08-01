/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 1  2-><-3<-4   null
         l
    r
dymmy->1->4->2->3->null
          t
 count = 0
 */
public class Leetcode143 {
    public void reorderList(ListNode head) {
        if(head.next == null || head.next.next == null) {
            return;
        }
        //Find the first middle node
        int count = 1;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }

        //Reverse the linked list from the middle node
        ListNode next = slow.next;

        while(next != null) {
            ListNode temp = next.next;
            next.next = slow;
            slow = next;
            next = temp;
        }

        //Form new linked list
        ListNode r = slow;
        ListNode l = head;
        ListNode dummy = new ListNode(0,null);
        ListNode tail = dummy;

        while (count>0) {
            if(l == r) {
                tail.next = l;
                tail = tail.next;
                break;
            }

            tail.next = l;
            ListNode temp = l.next;
            l.next = r;
            l = temp;
            r = r.next;
            tail = tail.next.next;
            count--;
        }

        tail.next = null;
    }
}