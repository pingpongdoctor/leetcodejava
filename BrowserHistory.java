class BrowserHistory {

  class ListNode {
      ListNode prev;
      ListNode next;
      String val;

      public ListNode (){
      }

      public ListNode (String val){
          this.val = val;
      }
  }

  ListNode left;
  ListNode right;
  ListNode cur;

  public BrowserHistory(String homepage) {
      left = new ListNode();
      right = new ListNode();
      cur = new ListNode(homepage);
      left.next = cur;
      right.prev = cur;
      cur.prev = left;
      cur.next = right;
  }
  
  public void visit(String url) {
      ListNode visitPage = new ListNode(url);
      cur.next = visitPage;
      visitPage.prev = cur;
      visitPage.next = right;
      right.prev = visitPage;
      cur = visitPage;
  }
  
  public String back(int steps) {
      for (int i=0; i<steps; i++){
          cur = cur.prev;
          if(cur==left){
              cur=cur.next;
              return cur.val;
          }
      }
      return cur.val;
  }
  
  public String forward(int steps) {

      for (int i=0; i<steps; i++){
          cur = cur.next;
          if(cur==right){
              cur=cur.prev;
              return cur.val;
          }
      }
      return cur.val;
  }
}

/**
* Your BrowserHistory object will be instantiated and called as such:
* BrowserHistory obj = new BrowserHistory(homepage);
* obj.visit(url);
* String param_2 = obj.back(steps);
* String param_3 = obj.forward(steps);
*/