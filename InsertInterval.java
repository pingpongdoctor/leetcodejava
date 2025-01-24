import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 57. Insert Interval
// Create a resizable list that contains all intervals then sort it
// Track start and end values of interval ranges to decide if we want to merge them
public class InsertInterval {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
    list.add(newInterval);
    Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));
    List<int[]> ans = new ArrayList<>();
    ans.add(list.get(0));
    int[] last = list.get(0);

    for (int i = 1; i < list.size(); i++) {
      int[] cur = list.get(i);

      if (cur[0] <= last[1]) {
        last[1] = Math.max(cur[1], last[1]);
      } else {
        ans.add(cur);
        last = cur;
      }
    }

    int[][] ansArr = ans.toArray(new int[ans.size()][ans.get(0).length]);

    return ansArr;
  }
}