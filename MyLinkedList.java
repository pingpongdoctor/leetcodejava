// 707. Design Linked List
class MyLinkedList {
  class ListNode {
      int val;
      ListNode prev;
      ListNode next;
      public ListNode(){
      }
      public ListNode(int val){
          this.val=val;
      }
  }
  ListNode head;
  ListNode tail;
  int length;

  public MyLinkedList() {
      head= new ListNode();
      tail= new ListNode();
      head.next=tail;
      tail.prev=head;
  }
  
  public int get(int index) {
      if(index>=length){
          return -1;
      }
      ListNode cur=head;
      for(int i=0; i<=index;i++){
          cur=cur.next; 
      }
      return cur.val;
  }
  
  public void addAtHead(int val) {
      ListNode newnew = new ListNode(val);
      ListNode temp = head.next;
      head.next = newnew;
      newnew.prev=head;
      newnew.next=temp;
      temp.prev=newnew;
      length++;
  }
  
  public void addAtTail(int val) {
      ListNode newnew = new ListNode(val);
      ListNode temp = tail.prev;
      temp.next = newnew;
      newnew.prev=temp;
      newnew.next=tail;
      tail.prev=newnew;
      length++;
  }
  
  public void addAtIndex(int index, int val) {
      if(index>length){
          return;
      }

      if(index==length){
          addAtTail(val);
          return;
      }

      ListNode newnew = new ListNode(val);
      ListNode cur = head;
      for(int i=0; i<=index;i++){
          cur=cur.next;
      }
      ListNode temp = cur.prev;
      temp.next=newnew;
      newnew.prev=temp;
      newnew.next=cur;
      cur.prev=newnew;
      length++;
  }
  
  public void deleteAtIndex(int index) {
      if(index>=length){
          return;
      }

      ListNode cur = head;
      for(int i=0; i<=index;i++){
          cur=cur.next;
      }
      ListNode temp1=cur.prev;
      ListNode temp2=cur.next;
      temp1.next=temp2;
      temp2.prev=temp1;
      length--;
  }
}

/**
* Your MyLinkedList object will be instantiated and called as such:
* MyLinkedList obj = new MyLinkedList();
* int param_1 = obj.get(index);
* obj.addAtHead(val);
* obj.addAtTail(val);
* obj.addAtIndex(index,val);
* obj.deleteAtIndex(index);
*/