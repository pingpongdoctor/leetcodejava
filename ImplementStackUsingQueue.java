// 225. Implement Stack using Queues

import java.util.LinkedList;
import java.util.Queue;

class ImplementStackUsingQueue {
  Queue<Integer> myData;

  public ImplementStackUsingQueue() {
      myData = new LinkedList<Integer>();
  }
  
  public void push(int x) {
      myData.add(x);
  }

  public int pop() { 
      if(myData.size()<2){
          return myData.remove();
      } else {
          for (int i = 0; i < myData.size()-1; i++){
              myData.add(myData.remove());
          }
          return myData.remove();
      }
  }
  
  public int top() {
      if(myData.size()<2){
          return myData.peek();
      } else {
          for (int i = 0; i < myData.size()-1; i++){
              myData.add(myData.remove());
          }
          int rs = myData.remove();
          myData.add(rs);
          return rs;
      }
  }
  
  public boolean empty() {
      return myData.isEmpty();
  }
}

/**
* Your MyStack object will be instantiated and called as such:
* MyStack obj = new MyStack();
* obj.push(x);
* int param_2 = obj.pop();
* int param_3 = obj.top();
* boolean param_4 = obj.empty();
*/