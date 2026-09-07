/**
Using the max heap to track the two largest stones in the list
Add [2,7,4,1,8,1] to max heap
poll first two elements and calculate the smashing result then add it back to the max heap if it is greater than 0
Time complexity: O(nlogn)
Space complexity: O(n)
*/
public class Leetcode1046 {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : stones) {
            maxHeap.add(num);
        }

        while(maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            int result = Math.abs(x-y);
            
            if(result > 0) {
                maxHeap.add(result);
            }
        }

        if(maxHeap.isEmpty()) {
            return 0;
        }

        return maxHeap.peek();
    }
}