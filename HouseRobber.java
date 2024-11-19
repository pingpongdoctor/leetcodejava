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

  // optimal solution with DP to calculate the base case of the last house
  public int rob2(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }

    int len = nums.length;
    int[] maxSum = { Math.max(nums[len - 2], nums[len - 1]), nums[len - 1] };
    for (int i = len - 3; i >= 0; i--) {
      int temp = maxSum[0];
      maxSum[0] = Math.max(maxSum[0], nums[i] + maxSum[1]);
      maxSum[1] = temp;
    }
    return maxSum[0];
  }
}