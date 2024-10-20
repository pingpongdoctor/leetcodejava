// 724. Find Pivot Index
public class FindPivotIndex {
  private int[] prefixSum(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      nums[i] = nums[i] + nums[i - 1];
      System.out.println(nums[i]);
    }
    return nums;
  }

  public int pivotIndex(int[] nums) {
    int[] prefixSum = prefixSum(nums);
    for (int i = 0; i < prefixSum.length; i++) {
      int left = i - 1;
      int right = i + 1;
      int leftSum = i == 0 ? 0 : prefixSum[left];
      int rightSum = prefixSum[prefixSum.length - 1] - prefixSum[right - 1];
      if (leftSum == rightSum) {
        return i;
      }
    }
    return -1;
  }
}