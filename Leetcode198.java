/**
Solution 1: Top-down soltuion with memoization
Time complexity: O(n)
Space complexity: O(n)
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
}