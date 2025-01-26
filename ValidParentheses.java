import java.util.HashMap;
import java.util.Stack;

//20. Valid Parentheses
class ValidParentheses {
  public boolean isValid(String s) {
    HashMap<Character, Character> map = new HashMap<Character, Character>();
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');

    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
    }

    for (Character c : s.toCharArray()) {
      if (stack.size() == 0) {
        stack.push(c);
        continue;
      }

      // if c is an openning one
      if (map.containsValue(c)) {
        stack.push(c);
        // if c is a closing one
      } else if (map.containsKey(c)) {
        if (!stack.pop().equals(map.get(c))) {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }
}