import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 15. 3Sum
// Three pointers
public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      int L = i + 1;
      int R = nums.length - 1;
      while (L < R) {
        int sum = nums[i] + nums[L] + nums[R];
        if (sum == 0) {
          ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
          L++;
          while (nums[L] == nums[L - 1] && L < R) {
            L++;
          }
        } else if (sum > 0) {
          R--;
        } else {
          L++;
        }
      }
    }

    return ans;
  }
}