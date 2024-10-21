import java.util.Arrays;

// 1679. Max Number of K-Sum Pairs
public class MaxNumberK {
  public int maxOperations(int[] nums, int k) {
    Arrays.sort(nums);
    int L = 0;
    int R = nums.length - 1;
    int count = 0;
    while (L < R) {
      if (nums[L] + nums[R] == k) {
        count++;
        L++;
        R--;
        continue;
      }

      if (nums[L] + nums[R] < k) {
        L++;
      } else {
        R--;
      }
    }
    return count;
  }
}