import java.util.Stack;

// 150. Evaluate Reverse Polish Notation
// Use stack to track the last two numbers in the array and interpret the operation when encoutering an operator
// The order of 2 numbers when executing the operation does matter
public class EvaluateReversePolishNotationSolved {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (String s : tokens) {
      if (stack.isEmpty()) {
        stack.push(Integer.parseInt(s));
        continue;
      }
      if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
        int num1 = stack.pop();
        int num2 = stack.pop();
        int rs = 0;
        if (s.equals("+")) {
          rs = num2 + num1;
        }
        if (s.equals("-")) {
          rs = num2 - num1;
        }
        if (s.equals("*")) {
          rs = num2 * num1;
        }
        if (s.equals("/")) {
          rs = num2 / num1;
        }
        stack.push(rs);
      } else {
        stack.push(Integer.parseInt(s));
      }
    }
    return stack.peek();
  }
}