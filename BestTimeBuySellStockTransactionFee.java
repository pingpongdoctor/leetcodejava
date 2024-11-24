public class BestTimeBuySellStockTransactionFee {
  public int maxProfit(int[] prices, int fee) {
    var n = prices.length;

    // rec + memo (top-down)
    return maxProfit(prices, fee, 0, 0, new Integer[n][2]);
  }

  private int maxProfit(int[] nums, int fee, int day, Integer haveStock, Integer[][] memo) {
    if (day == nums.length) {
      return 0;
    }

    if (memo[day][haveStock] != null) {
      return memo[day][haveStock];
    }

    var keepStockProfit = maxProfit(nums, fee, day + 1, haveStock, memo);

    var operationProfit = 0;
    if (haveStock == 1) {
      // sell
      operationProfit = nums[day] + maxProfit(nums, fee, day + 1, 0, memo) - fee;
    } else {
      // buy
      operationProfit = maxProfit(nums, fee, day + 1, 1, memo) - nums[day];
    }

    return memo[day][haveStock] = Math.max(keepStockProfit, operationProfit);
  }
}
