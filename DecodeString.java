import java.util.Stack;

// 394. Decode String
// two stacks solution
public class DecodeString {
  public String decodeString(String s) {
    StringBuilder sb = new StringBuilder();
    Stack<Integer> t = new Stack<>();
    Stack<StringBuilder> builders = new Stack<>();
    int k = 0;
    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        k = k * 10 + (c - '0');
      } else if (c == '[') {
        t.push(k);
        builders.push(sb);
        sb = new StringBuilder();
        k = 0;
      } else if (c == ']') {
        Integer times = t.pop();
        StringBuilder temp = sb;
        sb = builders.pop();
        while (times > 0) {
          sb.append(temp);
          times--;
        }
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}