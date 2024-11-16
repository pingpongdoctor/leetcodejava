import java.util.LinkedList;
import java.util.Queue;

// 933. Number of Recent Calls
//Queue solution to track the valid pings and poll the ping from queue that exceed the 3000 miliseconds range
public class NumberRecentCalls {
  Queue<Integer> queue;

  public NumberRecentCalls() {
    queue = new LinkedList<>();
  }

  public int ping(int t) {
    queue.add(t);
    while (queue.peek() < t - 3000) {
      queue.poll();
    }
    return queue.size();
  }
}