import java.util.ArrayDeque;
import java.util.Deque;

// 901. Online Stock Span
// Non-decreasing monotonic stack solution
public class OnlineStockSpan {
  class StockSpanner {
    private Deque<Integer[]> stack;

    public StockSpanner() {
      stack = new ArrayDeque<>();
    }

    public int next(int price) {
      int span = 1;
      while (!stack.isEmpty() && stack.peek()[0] <= price) {
        span += stack.pop()[1];
      }
      Integer[] newEle = { price, span };
      stack.push(newEle);
      return span;
    }
  }
}