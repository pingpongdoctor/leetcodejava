import java.util.ArrayDeque;
import java.util.Deque;

// 739. Daily Temperatures
// Use decreasing monotonic stack to find next greater elements
public class DailyTemperatures {
  public int[] dailyTemperatures(int[] temperatures) {
    Deque<Integer> stack = new ArrayDeque<>();
    int[] ans = new int[temperatures.length];
    for (int i = temperatures.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
        stack.pop();
      }
      ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
      stack.push(i);
    }
    return ans;
  }
}