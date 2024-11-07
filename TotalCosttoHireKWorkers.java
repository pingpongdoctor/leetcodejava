import java.util.PriorityQueue;
import java.util.Queue;

//Using to queue to track the first and last candidiates
// Using max_integer to avoid complicated complex condition handling
public class TotalCosttoHireKWorkers {
  public long totalCost(int[] costs, int k, int candidates) {
    int L = 0;
    int lastIndex = costs.length - 1;
    int R = lastIndex;
    long total = 0;
    Queue<Integer> minHeap1 = new PriorityQueue<>();
    Queue<Integer> minHeap2 = new PriorityQueue<>();

    while (k > 0) {
      if (L <= R && minHeap1.size() < candidates) {
        minHeap1.offer(costs[L]);
        L++;
      }
      if (L <= R && minHeap2.size() < candidates) {
        minHeap2.offer(costs[R]);
        R--;
      }
      if ((minHeap1.size() >= candidates || minHeap2.size() >= candidates) || L > R) {
        int val1 = minHeap1.isEmpty() ? Integer.MAX_VALUE : minHeap1.peek();
        int val2 = minHeap2.isEmpty() ? Integer.MAX_VALUE : minHeap2.peek();
        if (val1 > val2) {
          total += val2;
          minHeap2.poll();
        } else {
          total += val1;
          minHeap1.poll();
        }
        k--;
        continue;
      }
    }
    return total;
  }
}