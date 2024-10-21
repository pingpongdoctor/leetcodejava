// 11. Container With Most Water
public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    int L = 0;
    int R = height.length - 1;
    int max = 0;
    while (L < R) {
      int h = Math.min(height[L], height[R]);
      int w = R - L;
      max = Math.max(max, h * w);
      if (height[L] < height[R]) {
        L++;
      } else {
        R--;
      }
    }
    return max;
  }
}