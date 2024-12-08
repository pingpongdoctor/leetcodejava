
// 435. Non-overlapping Intervals
// sorting the intervals list and count the non overlapping intervals
// update the last interval if it is not overlapping
// jump to next interval if the current one is overlapping (delete the overlapping one)
import java.util.Arrays;

public class NonoverlappingIntervals {
  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 1) {
      return 0;
    }
    Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
    int nonOverlap = 1;
    int lastEnd = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= lastEnd) {
        lastEnd = intervals[i][1];
        nonOverlap++;
      }
    }
    return intervals.length - nonOverlap;
  }
}