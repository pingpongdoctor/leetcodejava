// 334. Increasing Triplet Subsequence
//set min1 and min2 then find if min3 exists
public class IncreasingTripletSubsequence {
  public boolean increasingTriplet(int[] nums) {
    if (nums.length < 3) {
      return false;
    }
    int min = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;
    for (int n : nums) {
      if (n <= min) {
        min = n;
      } else if (n <= secondMin) {
        secondMin = n;
      } else {
        return true;
      }
    }
    return false;
  }
}