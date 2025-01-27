import java.util.Stack;

// 71. Simplify Path
// Use stack to track the structure of the path
// Build the path using for loop to iterate from left to right since we want to approach the the stack from the bottom
class SimplifyPath {
  public String simplifyPath(String path) {
    String[] arr = path.split("/");
    Stack<String> stack = new Stack<>();

    for (String s : arr) {
      System.out.println(s);
      if (s.equals("") || s.equals(".")) {
        continue;
      }

      if (s.equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
        continue;
      }

      stack.push(s);
    }

    StringBuilder ans = new StringBuilder();

    for (String str : stack) {
      ans.append("/");
      ans.append(str);
    }

    return ans.isEmpty() ? "/" : ans.toString();
  }
}