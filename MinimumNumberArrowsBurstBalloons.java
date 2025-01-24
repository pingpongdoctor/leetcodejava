import java.util.Arrays;

// 452. Minimum Number of Arrows to Burst Balloons
// Sort the intervals by the end values
// Use the end value of the previous range to track the back of the last interval and check if it overlaps with the current interval
public class MinimumNumberArrowsBurstBalloons {
  public int findMinArrowShots(int[][] points) {
    if (points.length == 1) {
      return 1;
    }

    Arrays.sort(points, (a, b) -> a[1] - b[1]);
    int exploded = 1;
    int lastEnd = points[0][1];
    for (int i = 1; i < points.length; i++) {
      if (points[i][0] > lastEnd) {
        exploded++;
        lastEnd = points[i][1];
      }
    }
    return exploded;
  }
}