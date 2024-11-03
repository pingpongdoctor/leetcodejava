// 1493. Longest Subarray of 1's After Deleting One Element
public class LongestSubarrayAfterDeletingOneElement {
  public int longestSubarray(int[] nums) {
    int L = 0;
    int countZero = 0;
    int max = 0;
    for (int R = 0; R < nums.length; R++) {
      if (nums[R] == 0) {
        countZero++;
      }
      while (countZero > 1) {
        if (nums[L] == 0) {
          countZero--;
        }
        L++;
      }
      max = Math.max(max, R - L + 1);
    }
    if (countZero == 0) {
      return nums.length - 1;
    }
    return max - 1;
  }
}