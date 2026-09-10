import java.util.PriorityQueue;

/**
Solution 1: Max heap
Solution 2: Finding the element at index n - k in a sorted array. We use Quickselect to divide the array into elements smaller, equal, and greater than areas with a randomly chosen pivot. Because we only need to search the side that contains our target index N - k, we discard the other half at each step. Having 3 partition areas handle the edge case of all duplicate elements and using the random pivot handles the edge case of having all elements on the right hand side bigger than the left ones. These cases are worst scenarios that increase the time complexity to O(n^2)

[1  5   2   6   4   3], k = 2 pivot = 1 expect = 4
    c
 l
 g

greaterIdx = 0 != 2
if(expect > greater) {
partition from greater + 1 to right
}
if(expect < lesser) {
partition from left to lesser
}

if(expect >= lesser && expect <=greater) {
return nums[expected]
}

                                  
                                      
while c <= greater
 if(c<p) {swap c and l, c++, l++}
 if(c>p) {swap c and g, g--}
 else {c++}
 elements smaller than pivot is in range left to less - 1
 elements greater than pivot is in range greater + 1 to right
 elements that are equals to pivot is in range less to great

 everytime the array is partitioned, we throw almost a haft of it and look for the target on one side of the pivot

 Time complexity: n + n/2 + n/4 + ... < 2n -> O(n);
 Space complexity: O(1)

*/

public class Leetcode215 {
    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int[] partition(int[] nums, int left, int right) {
        //handle the array that has all duplicates by using three partitions
        int cur = left;
        int less = left;
        int greater = right;
        //choose a random pivot to handle the case that right elements are always greater than left
        int pivotIdx = (int) (left + Math.random() * (right - left + 1));
        int pivot = nums[pivotIdx];

        while (cur <= greater) {
            if (nums[cur] < pivot) {
                swap(nums,cur,less);
                less++;
                cur++;
            } else if (nums[cur] > pivot) {
                swap(nums,cur,greater);
                greater--;
            } else {
                cur++;
            }
        }

        return new int[]{less, greater};
    }

    public int findKthLargest(int[] nums, int k) {
        int expected = nums.length - k;
        int left = 0;
        int right = nums.length - 1;

        while (true) {
            int[] arr = partition(nums, left, right);
            int less = arr[0];
            int greater = arr[1];
            
            if(expected < less) {
                right = less - 1;
            } else if (expected > greater) {
                left = greater + 1;
            } else {
                return nums[expected];
            }
        }

      public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int val : nums) {
            if (minHeap.size() < k) {
                minHeap.add(val);
            } else {
                if (val > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(val);
                }
            }
        }

        return minHeap.peek();
        }
}