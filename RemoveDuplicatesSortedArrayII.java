//80. Remove Duplicates from Sorted Array II
//use two pointers
public class RemoveDuplicatesSortedArrayII {
  public int removeDuplicates(int[] nums) {
    int count = 1;
    int p = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[p] && count < 2) {
        count++;
        nums[p + 1] = nums[i];
        p++;
      } else if (nums[i] != nums[p]) {
        nums[p + 1] = nums[i];
        p++;
        count = 1;
      }
    }
    return p + 1;
  }
}