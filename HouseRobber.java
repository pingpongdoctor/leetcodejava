// 198. House Robber
public class HouseRobber {
  int maxSum = Integer.MIN_VALUE;

  // dfs solution
  private void dfs(int curSum, int idx, int[] nums) {
    maxSum = Math.max(curSum, maxSum);
    if (idx > nums.length - 1) {
      return;
    }
    for (int i = idx; i < nums.length; i++) {
      curSum += nums[i];
      dfs(curSum, i + 2, nums);
      curSum -= nums[i];
    }
  }

  public int rob(int[] nums) {
    dfs(0, 0, nums);
    return maxSum;
  }

  // optimal solution with DP
}