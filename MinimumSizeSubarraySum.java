// 209. Minimum Size Subarray Sum
// Sliding window
public class MinimumSizeSubarraySum {
  public int minSubArrayLen(int target, int[] nums) {
    if (nums.length == 1) {
      return nums[0] >= target ? 1 : 0;
    }

    int L = 0;

    int len = Integer.MAX_VALUE;
    int sum = 0;

    for (int R = 0; R < nums.length; R++) {
      sum += nums[R];

      while (sum >= target) {
        len = Math.min(R - L + 1, len);
        sum -= nums[L];
        L++;
      }
    }

    if (len == Integer.MAX_VALUE) {
      return 0;
    }
    return len;
  }
}