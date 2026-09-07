/**
solution 1:
list of score that is sorted. everytime we add new score, we need to sort O(n.logn)
return list.get(k-1)
solution 2: us min heap to track the k largest element. If the min heap stores k largest elements, the peek element in the heap is the kth largest element
*/

public class Leetcode703 {
    private PriorityQueue<Integer> minHeap;
    private int k;

    private void helper(int val) {
        if(minHeap.size() < k) {
            minHeap.add(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.add(val);
        }
    }

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for(int num : nums) {      
            helper(num);
        }
    }
    
    public int add(int val) {
        helper(val);
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */