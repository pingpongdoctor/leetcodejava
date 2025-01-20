import java.util.HashMap;
import java.util.Map;

// 1. Two Sum
// Instead of sorting and using map to store index, we can just use map to track the if the current value has an exsisting element in the map that can add up to it to equal to the target
public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    int[] ans = new int[2];
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int x = target - nums[i];
      if (map.containsKey(x)) {
        ans[0] = map.get(x);
        ans[1] = i;
      }
      map.put(nums[i], i);
    }

    return ans;
  }
}