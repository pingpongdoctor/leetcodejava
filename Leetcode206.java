/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 Solution 1
null<-1<-2<-3<-4<-5
      h
                  p c
         
temp = c.next
c.next = p
p = p.next
c = t
return p

Edge case of 2 nodes
null<-1<-2  null
         p
             c  
         
Test
null<-1<-2<-3<-4<-5
                  p   
                      c
 */
class Leetcode206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }
}