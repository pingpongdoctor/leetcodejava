import java.util.Collections;
import java.util.PriorityQueue;

// 703. Kth Largest Element in a Stream
public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }
        while (k > 1) {
            minHeap.poll();
            k--;
        }
        return minHeap.peek();
    }
}
