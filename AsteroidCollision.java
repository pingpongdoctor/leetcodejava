import java.util.Stack;

//735. Asteroid Collision
//stack solution
//the peek element in stack is the first asteroid coliding with the current element in asteroids array
public class AsteroidCollision {
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    stack.push(asteroids[0]);
    int i = 1;
    while (i < asteroids.length) {
      int cur = asteroids[i];
      if (stack.empty()) {
        stack.push(cur);
        i++;
        continue;
      }
      int p = stack.peek();
      if (!(p > 0 && cur < 0)) {
        stack.push(cur);
        i++;
        continue;
      }
      if (cur + p == 0) {
        stack.pop();
        i++;
        continue;
      }
      if (Math.abs(cur) > Math.abs(p)) {
        stack.pop();
      } else {
        i++;
      }
    }
    int[] ans = new int[stack.size()];
    for (int j = stack.size() - 1; j >= 0; j--) {
      ans[j] = stack.pop();
    }
    return ans;
  }
}