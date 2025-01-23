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

    for (int i = 0; i < intervals.length; i++) {
      if (i == 0) {
        ans.add(intervals[i]);
        continue;
      }

      int[] lastEle = ans.get(ans.size() - 1);
      int start1 = lastEle[0];
      int end1 = lastEle[1];

      int[] curInterval = intervals[i];
      int start2 = curInterval[0];
      int end2 = curInterval[1];

      if (end1 >= start2 && start1 <= end2) {
        int[] newArr = { Math.min(start1, start2), Math.max(end1, end2) };
        ans.remove(ans.size() - 1);
        ans.add(newArr);
      } else {
        ans.add(intervals[i]);
      }
    }

    int[][] ansArr = ans.toArray(new int[ans.size()][ans.get(0).length]);
    return ansArr;
  }
}