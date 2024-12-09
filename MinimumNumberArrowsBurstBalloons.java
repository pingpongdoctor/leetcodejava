import java.util.Arrays;

// 452. Minimum Number of Arrows to Burst Balloons
// Use lastend to track the back of the last interval and check if it overlaps with the current interval
public class MinimumNumberArrowsBurstBalloons {
  public int findMinArrowShots(int[][] points) {
    if (points.length == 1) {
      return 1;
    }

    Arrays.sort(points, (a, b) -> a[1] - b[1]);
    int exploded = 1;
    int lastEnd = points[0][1];
    for (int i = 1; i < points.length; i++) {
      if (lastEnd <= points[i][1] && lastEnd >= points[i][0]) {
        continue;
      } else {
        lastEnd = points[i][1];
        exploded++;
      }
    }
    return exploded;
  }
}