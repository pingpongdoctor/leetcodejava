import java.util.PriorityQueue;
// 703. Kth Largest Element in a Stream
public class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<Integer>();
        this.k = k;
        for(int i = 0; i<nums.length; i++){
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        //generate minHeap that has k largest values in nums and the root value is the k largest value
        if(minHeap.size()<k){
            minHeap.offer(val);
        }else if(val>minHeap.peek()){
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}
