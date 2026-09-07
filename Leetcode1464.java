/**
0   1   2   3
3   4   5   2
i
    j

solution 1: sorting
time: nlogn
space: O(1)
2   3   4   5 
        i   j
i and j should be 2 last elements

solution 2: The problem requires looking for 2 largest elements. Use min heap to find the two largest elements then return the product of them using the fomular.
*/
public class Leetcode1464 {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];

            if(heap.size() < 2) {
                heap.add(cur);
                continue;
            }

            if (heap.size() == 2 && cur > heap.peek()) {
                heap.poll();
                heap.add(cur);
            }
        }

        return (heap.poll() - 1) * (heap.peek() - 1);
    }
}