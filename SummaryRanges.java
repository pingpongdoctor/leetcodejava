import java.util.ArrayList;
import java.util.List;

// 228. Summary Ranges
// interval solution with start variable to check the beginning of each interval to see if the intervals have more than one element
public class SummaryRanges {
  public List<String> summaryRanges(int[] nums) {
    List<String> rs = new ArrayList<>();

    if (nums.length == 0) {
      return rs;
    }

    if (nums.length == 1) {
      rs.add(nums[0] + "");
      return rs;
    }

    // from or to
    int start = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] - nums[i - 1] == 1) {
        if (i == nums.length - 1) {
          rs.add(start + "->" + nums[i]);
        }
        continue;
      }

      if (start == nums[i - 1]) {
        rs.add(start + "");
      } else {
        rs.add(start + "->" + nums[i - 1]);
      }

      start = nums[i];

      if (start == nums[nums.length - 1]) {
        rs.add(start + "");
      }
    }

    return rs;
  }
}