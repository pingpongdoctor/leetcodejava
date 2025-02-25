// 148. Sort List
// Implement merge sort on list
public class SortList {
    class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

      private ListNode mergeSort(ListNode head){
        if(head==null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(mid);

        return merge(left,right);
    }

    private ListNode merge(ListNode left, ListNode right){
        ListNode dummyNode = new ListNode();
        ListNode p = dummyNode;

        while(left!=null && right!=null){
            if(left.val<right.val){
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        if(left!=null){
            p.next = left;
        }

        if(right!=null){
            p.next = right;
        }
        return dummyNode.next;
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}
