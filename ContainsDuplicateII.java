import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 219. Contains Duplicate II
public class ContainsDuplicateII {
  // use hashmap to track index and value
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    boolean ans = false;

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int cur = nums[i];

      if (!map.containsKey(cur)) {
        map.put(cur, i);
      } else {
        if (Math.abs(i - map.get(cur)) <= k) {
          ans = true;
          break;
        }
        map.put(cur, i);
      }
    }

    return ans;
  }

  // use hashset to track values and use two pointers to track the range which is
  // calculated by subtracting indices
  public boolean containsNearbyDuplicate2(int[] nums, int k) {
    boolean ans = false;

    Set<Integer> set = new HashSet<>();
    int L = 0;

    for (int R = 0; R < nums.length; R++) {
      if (R - L > k) {
        set.remove(nums[L]);
        L++;
      }

      if (set.contains(nums[R])) {
        ans = true;
        break;
      }

      set.add(nums[R]);
    }

    return ans;
  }
}
