/**
Time complexity: O(n)
Space complexity: O(n)
*/

public class Leetcode746 {
    public int minCostClimbingStairs(int[] cost) {
        int size = cost.length;
        int[] memo = new int[cost.length + 1];
        
        for(int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return helper(size, cost, memo);
    }
    private int helper(int idx, int[] cost, int[] memo) {
        if(idx == 0 || idx == 1) {
            return 0;
        }

        if(memo[idx] != -1) {
            return memo[idx];
        }
        
        memo[idx] = Math.min(helper(idx-1, cost, memo) + cost[idx-1], helper(idx-2, cost, memo) + cost[idx - 2]);

        return memo[idx];
    }
}