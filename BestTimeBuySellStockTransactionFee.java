public class BestTimeBuySellStockTransactionFee {
  // DFS + memoization (top-down solution)
  private int dfs(int hold, int idx, int[] prices, int fee, Integer[][] memo) {
    if (idx >= prices.length) {
      return 0;
    }
    if (memo[idx][hold] != null) {
      return memo[idx][hold];
    }
    int profit = dfs(hold, idx + 1, prices, fee, memo);
    if (hold == 0) {
      // Case 2: Buy stock
      profit = Math.max(profit, dfs(1, idx + 1, prices, fee, memo) - prices[idx]);
    } else {
      // Case 3: Sell stock
      profit = Math.max(profit, dfs(0, idx + 1, prices, fee, memo) + prices[idx] - fee);
    }
    memo[idx][hold] = profit;
    return profit;
  }

  public int maxProfit(int[] prices, int fee) {
    return dfs(0, 0, prices, fee, new Integer[prices.length][2]);
  }
}