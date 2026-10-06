/**
Top down solution with memoization
Time complexity: O(n)
Space complexity: O(n)
*/

public class Leetcode309 {
    public int maxProfit(int[] prices) {
        int[][] memo = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            memo[i][0] = -1;
            memo[i][1] = -1;
        }
        
        return dp(prices, 0, false, memo);
    }
    private int dp(int[] prices, int idx, boolean isHolding, int[][] memo) {
        if(idx >= prices.length) {
            return 0;
        }

        if(memo[idx][isHolding ? 1 : 0] != -1) {
            return memo[idx][isHolding ? 1 : 0];
        }

        int max = 0;

        if(isHolding) {
            max = Math.max(prices[idx] + dp(prices, idx+2, false, memo), dp(prices, idx+1, true, memo));
        } else {
            max = Math.max(dp(prices, idx+1, true, memo) - prices[idx], dp(prices, idx+1, false, memo));
        }

        memo[idx][isHolding ? 1 : 0] = max;

        return max;
    }
}