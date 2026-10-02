/**
    0   1   2   3   4   5   
    0   1   0   3   2   3
    i

    0   1   2   3   4   5
dp  1   1   1   1   1   1

i = 0
cur = 0

inner loop looping from 0 to i - 1 with j is the control variable
if(j element < i element) {update dp[i] = max of dp[i] and dp[j] + 1}

return the maximum value in dp

time complexity: O(n^2)
space complexity: O(n)

Test
 0 1 2 3 4 5
[0,1,0,3,2,3]
[1,2,1,3,1,1]

i = 3
cur = 3
j = 2

*/


public class Leetcode300 {
    public int lengthOfLISTopDown(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] memo = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, helper(nums, i, -1, memo));
        }
        return max;
    }

    private int helper(int[] nums, int idx, int prevIdx, int[] memo){
        if(idx >= nums.length) {
            return 0;
        }

        if(prevIdx != -1 && nums[idx] <= nums[prevIdx]) {
            return 0;
        }

        if(prevIdx != -1 && memo[idx] != 0) {
            return memo[idx];
        }

        int max = 1;

        for (int i = idx+1; i < nums.length; i++) {
            max = Math.max(max, 1 + helper(nums, i, idx, memo));
        }

        if(prevIdx != -1) {
            memo[idx] = max;
        }
        
        return max;
    }

    public int lengthOfLISBottomDown(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }

        int[] dp = new int[nums.length];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            for (int j = 0; j < i; j++) {
                if(nums[j] < cur) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 1;
        for (int num : dp) {
            max = Math.max(max, num);
        }

        return max;
    }
}