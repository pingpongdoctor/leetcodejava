public class BestTimeBuySellStock {
  // keep buy price minium
  public int maxProfit(int[] prices) {
    int buyPrice = prices[0];
    int profit = Integer.MIN_VALUE;
    for (int n : prices) {
      buyPrice = Math.min(buyPrice, n);
      profit = Math.max(profit, n - buyPrice);
    }
    return profit;
  }

  // DP topdown solution
  private int dfs(int[] prices, int hold, Integer[][] max, int idx) {
    if (idx >= prices.length || hold == 0) {
      return 0;
    }
    if (max[idx][hold] != null) {
      return max[idx][hold];
    }
    int profit = dfs(prices, hold, max, idx + 1);
    if (hold == 1) {
      profit = Math.max(profit, dfs(prices, 0, max, idx + 1) + prices[idx]);
    } else {
      profit = Math.max(profit, dfs(prices, 1, max, idx + 1) - prices[idx]);
    }
    max[idx][hold] = profit;
    return profit;
  }

  public int maxProfit2(int[] prices) {
    return dfs(prices, 2, new Integer[prices.length][3], 0);
  }
}