/**
Solution 1: Top-down soltuion with memoization
Time complexity: O(n)
Space complexity: O(n)

Solution 2: Bottom up. As we know the max rob of last and second last elements, we can calculate from right to left

    0   1   2   3
    2   1   1   2
    i
    cur = 2
    next = 3 

Time complexity: O(n)
Space complexity: O(1)
*/

public class Leetcode198 {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        for ( int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return helper(nums, 0, memo);
    }
    private int helper(int[] nums, int i, int[] memo) {
        if (i >= nums.length) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int option1 = helper(nums, i+2, memo) + nums[i];
        int option2 = helper(nums, i+1, memo);

        memo[i] = Math.max(option1, option2);

        return memo[i];
    }

    public int rob2(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }

        int next = nums[nums.length - 1];
        int cur = Math.max(nums[nums.length - 2], next);

        for(int i = nums.length - 1 - 2; i >= 0; i--) {
            int temp = cur;
            cur = Math.max(nums[i] + next, cur);
            next = temp;
        }

        return cur;
    }
}