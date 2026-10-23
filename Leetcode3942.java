/**
 * Checks whether the array follows a cyclic increasing or cyclic decreasing
 * order. idx is the index of 0 in the original array. step is either
 * 1 or -1, where 1 means traversing to the right and -1 means traversing
 * to the left.
 * 
 * If the array follows neither order, return -1.
 * 
 * If the array follows a cyclic increasing order, there are two ways to
 * transform it into an ascending sorted array: rotate left to bring 0 to
 * the beginning, or reverse the array and then rotate left or right to
 * obtain the ascending order.
 * 
 * If the array follows a cyclic decreasing order, there are two ways to
 * transform it into an ascending sorted array: reverse the array to obtain
 * a cyclic increasing order and then rotate left, or rotate left and then
 * reverse the array.
 * 
 * Two rules must be followed. After reversing the array, update the index
 * of 0 to n - 1 - idx. When rotating left as part of the second approach
 * for a cyclic decreasing array, 0 must first be moved to the end so that
 * reversing the array places it at the beginning. This requires idx + 1
 * left rotations.
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

public class Leetcode3942 {
    private boolean isValid(int[] nums, int idx, int step) {
        // interate from 0 to the last element in a continuous loop
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int cur = (idx + i * step + n) % n;
            int next = (idx + (i + 1) * step + n) % n;
            int curVal = nums[cur];
            int nextVal = nums[next];

            if (i == n - 1) {
                if (curVal != n - 1 || nextVal != 0) {
                    return false;
                }
            } else {
                if (nextVal - curVal != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public int minOperations(int[] nums) {
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (cur == 0) {
                idx = i;
                break;
            }
        }

        boolean isIncreasing = isValid(nums, idx, 1);
        boolean isDecreasing = isValid(nums, idx, -1);

        if (!isIncreasing && !isDecreasing) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int n = nums.length;

        if (isIncreasing) {
            min = Math.min(min, idx);
            min = Math.min(min, n - idx + 2);
        } else {
            min = Math.min(min, n - idx);
            min = Math.min(min, idx + 2);
        }

        return min;
    }
}