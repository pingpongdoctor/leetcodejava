import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 56. Merge Intervals
// merge interval if start1 <= end2 and end1 >= start1
// merged interval will have the range from Math.min(start1,start2) to Math.max(end1,end2)
public class MergeIntervals {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    List<int[]> ans = new ArrayList<>();
    ans.add(intervals[0]);
    int[] last = intervals[0];

    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] <= last[1]) {
        last[1] = Math.max(last[1], intervals[i][1]);
      } else {
        ans.add(intervals[i]);
        last = intervals[i];
      }
    }

    int[][] ansArr = ans.toArray(new int[ans.size()][ans.get(0).length]);
    return ansArr;
  }
}