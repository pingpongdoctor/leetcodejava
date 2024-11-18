// 746. Min Cost Climbing Stairs
// Use bottom up DP solution to calculate the base case first at the top of the stair
public class MinCostClimbingStairs {
  public int minCostClimbingStairs(int[] cost) {
    if (cost.length == 2) {
      return Math.min(cost[0], cost[1]);
    }
    int len = cost.length;
    int[] minCosts = { cost[len - 2], cost[len - 1] };
    for (int i = len - 3; i >= 0; i--) {
      int temp = minCosts[0];
      minCosts[0] = cost[i] + Math.min(minCosts[0], minCosts[1]);
      minCosts[1] = temp;
    }
    return Math.min(minCosts[0], minCosts[1]);
  }
}