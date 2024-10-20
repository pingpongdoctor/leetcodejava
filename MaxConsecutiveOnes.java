//1004. Max Consecutive Ones III
//Look then longest sublist with k most 0 values
public class MaxConsecutiveOnes {
  public int longestOnes(int[] nums, int k) {
    int L = 0;
    int countZero = 0;
    int max = 0;
    for (int R = 0; R < nums.length; R++) {
      if (nums[R] == 0) {
        countZero++;
      }
      while (countZero > k) {
        if (nums[L] == 0) {
          countZero--;
        }
        L++;
      }
      max = Math.max(max, R - L + 1);
    }
    return max;
  }
}