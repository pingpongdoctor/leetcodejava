
class MergeSortKLists {

 public class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

 //  Solution using Iterative to access every two lists in the array and Merge Sort
  public ListNode mergeKLists(ListNode[] lists) {
      if(lists.length==0 || lists==null){return null;}

      while (lists.length>1){
          ListNode[] newMergeLists= new ListNode[(lists.length+1)/2];
          for(int i=0;i<lists.length; i=i+2){
              if(i==lists.length-1){
                  newMergeLists[i/2]=lists[i];
              }
              else{
                  newMergeLists[i/2]=mergeSortTwoLists(lists[i],lists[i+1]);
              }
          }
          lists=newMergeLists;
      }
      return lists[0];
  }

  private ListNode mergeSortTwoLists(ListNode l1, ListNode l2) {
      ListNode newList = new ListNode();
      ListNode p = newList;
      while(l1!=null && l2!=null) {
          if(l1.val>l2.val){
              p.next=l2;
              l2=l2.next;
          }else{
              p.next=l1;
              l1=l1.next;
          }
          p=p.next;
      }

      if(l1!=null){
          p.next=l1;
      }
      if(l2!=null){
          p.next=l2;
      }
      return newList.next;
  }
}