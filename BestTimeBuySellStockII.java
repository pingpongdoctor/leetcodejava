//122. Best Time to Buy and Sell Stock II
//topdpwn solution
class BestTimeBuySellStockII {
  public int maxProfit(int[] prices) {
    // max profit is equivalent to the sum of profits that are obtained by selling
    // when current day's price is greater than previous day's price
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        profit += prices[i] - prices[i - 1];
      }
    }
    return profit;
  }

  // DP topdown solution
  private int dfs(int[] prices, int idx, Integer[][] memo, int hold) {
    if (idx > prices.length - 1) {
      return 0;
    }
    if (memo[idx][hold] != null) {
      return memo[idx][hold];
    }
    // skip
    int profit = dfs(prices, idx + 1, memo, hold);
    if (hold == 1) {
      // sell
      profit = Math.max(profit, dfs(prices, idx + 1, memo, 0) + prices[idx]);
    } else {
      // buy
      profit = Math.max(profit, dfs(prices, idx + 1, memo, 1) - prices[idx]);
    }
    memo[idx][hold] = profit;
    return profit;
  }

  public int maxProfit2(int[] prices) {
    return dfs(prices, 0, new Integer[prices.length][2], 0);
  }
}