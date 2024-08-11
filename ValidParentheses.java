import java.util.HashMap;
import java.util.Stack;

//20. Valid Parentheses
class ValidParentheses {
  public boolean isValid(String s) {
    HashMap<Character,Character> closings = new HashMap<Character,Character>();
    closings.put(')','(');
    closings.put('}','{');
    closings.put(']','[');

    Stack<Character> openings = new Stack<Character>();
    for(int i=0;i<s.length();i++){
    }

    for (int i=0; i<s.length();i++){
      if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
        openings.push(s.charAt(i));
      }else if (openings.isEmpty() || openings.pop() != closings.get(s.charAt(i))) {
        return false;
      }
    }
    if(openings.isEmpty()){
      return true;
    }
    return false;
  }
}