import java.util.Stack;

class MinStack {
  Stack<Integer> min= new Stack<Integer>();
  Stack<Integer> stack = new Stack<Integer>();

  public MinStack() {
  }

  public void push(int val) {
      stack.push(val);
        if(min.isEmpty()==false||val<min.peek()){
          min.push(val);
      }
  }
  
  public void pop() {
      if(stack.size()!=0){
        if (stack.pop()==min.peek()){
          min.pop();
        }
      }
  }
  
  public int top() {
      return stack.peek();
  }
  
  public int getMin() {
      return min.peek();
  }
}

/**
* Your MinStack object will be instantiated and called as such:
* MinStack obj = new MinStack();
* obj.push(val);
* obj.pop();
* int param_3 = obj.top();
* int param_4 = obj.getMin();
*/