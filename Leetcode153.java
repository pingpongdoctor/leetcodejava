/**
Solution: Use binary search to search for the smallest elemetn. The rule is that if the mid value is less than or equal to the right value, search on the left, otherwise, search on the right.

Time complexity: O(logn)
Space complexity: O(1)
*/

public class Leetcode153 {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = nums[0];

        while (l <= r) {
            int m = l + (r-l)/2;
            int midVal = nums[m];
            min = Math.min(min, midVal);

            if(midVal <= nums[r]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return min;
    }
}