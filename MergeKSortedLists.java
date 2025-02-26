import java.util.ArrayList;
import java.util.List;

// 23. Merge k Sorted Lists
// merging every two sorted listnodes ultil there is only one listnode remained in the array
public class MergeKSortedLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        if(lists.length==1){
            return lists[0];
        }
        while(lists.length>1){
            List<ListNode> temp = new ArrayList<>();
            int len = lists.length;
            for(int i = 0; i<len; i+=2){
                ListNode l1 = lists[i];
                if(i==lists.length-1){
                    temp.add(l1);
                    continue;
                }
                ListNode l2 = lists[i+1];
                ListNode dummy = new ListNode();
                ListNode p = dummy;
                while(l1!=null && l2!=null){
                    if(l1.val<l2.val){
                        p.next = l1;
                        l1 = l1.next;
                    } else {
                        p.next = l2;
                        l2 = l2.next;
                    }
                    p = p.next;
                }
                p.next = l1!=null ? l1 : l2;
                temp.add(dummy.next);
                dummy.next = null;
            }
            lists = temp.toArray(new ListNode[(int) Math.ceil(len/2)]);
        }
        return lists[0];
    }
}
