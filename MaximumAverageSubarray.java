// 643. Maximum Average Subarray
public class MaximumAverageSubarray {
  public double findMaxAverage(int[] nums, int k) {
    int L = 0;
    double curSum = 0;
    double averageVal = Integer.MIN_VALUE;
    for (int R = 0; R < nums.length; R++) {
      curSum += nums[R];
      if (R - L + 1 == k) {
        averageVal = Math.max(averageVal, curSum / k);
        curSum -= nums[L];
        L++;
      }
    }
    return averageVal;
  }
}
