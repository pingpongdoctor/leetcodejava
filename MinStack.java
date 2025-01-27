import java.util.Stack;

// 155. Min Stack
class MinStack {
  Stack<Integer> min = new Stack<Integer>();
  Stack<Integer> stack = new Stack<Integer>();

  public MinStack() {
  }

  public void push(int val) {
    stack.push(val);
    if (min.isEmpty() == false || val <= min.peek()) {
      min.push(val);
    }
  }

  public void pop() {
    if (!stack.isEmpty()) {
      int removedValue = stack.pop();
      if (removedValue == min.peek()) {
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