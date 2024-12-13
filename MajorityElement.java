import java.util.HashMap;
import java.util.Map;

//169. Majority Element
//hashmap solution
public class MajorityElement {
  public int majorityElement(int[] nums) {
    int times = nums.length / 2;
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      if (!map.containsKey(n)) {
        map.put(n, 1);
      } else {
        map.put(n, map.get(n) + 1);
      }
    }
    int rs = nums[0];
    for (Integer val : map.values()) {
      if (val > times) {
        rs = val;
      }
    }
    return rs;
  }
}