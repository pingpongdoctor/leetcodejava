import java.util.PriorityQueue;

// 215. Kth Largest Element in an Array
public class KthLargestElementArray {
        public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int val : nums){
            minHeap.add(val);
        }
        while(minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
