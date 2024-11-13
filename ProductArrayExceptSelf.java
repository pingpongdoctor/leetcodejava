// 238. Product of Array Except Self
public class ProductArrayExceptSelf {
  // use prefix and suffix to calculate the products of left and right elements
  // then calculate the product of all elements except the current element
  public int[] productExceptSelf(int[] nums) {
    int len = nums.length;
    int[] prefix = new int[len];
    prefix[0] = 1;
    int[] suffix = new int[len];
    suffix[len - 1] = 1;
    for (int i = 1; i < len; i++) {
      prefix[i] = i > 1 ? prefix[i - 1] * nums[i - 1] : nums[i - 1];
    }
    for (int i = len - 2; i >= 0; i--) {
      suffix[i] = i < len - 2 ? suffix[i + 1] * nums[i + 1] : nums[i + 1];
    }
    for (int i = 0; i < len; i++) {
      nums[i] = prefix[i] * suffix[i];
    }
    return nums;
  }
}