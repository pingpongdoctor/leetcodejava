// 162. Find Peak Element
//Binary search
public class FindPeakElement {
  public int findPeakElement(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }
    if (nums.length == 2) {
      return nums[0] > nums[1] ? 0 : 1;
    }
    int L = 0;
    int R = nums.length - 1;
    int rs = 0;

    while (L <= R) {
      int mid = (R + L) / 2;
      int cur = nums[mid];
      // first or last index
      if ((mid == 0 && cur > nums[mid + 1]) || (mid == nums.length - 1 && cur > nums[mid - 1])) {
        rs = mid;
        break;
      }

      // index in the middle
      if (cur > nums[mid - 1] && cur > nums[mid + 1]) {
        rs = mid;
        break;
      }

      // shrinking the window
      if (cur < nums[mid - 1]) {
        R = R - 1;
        continue;
      }
      if (cur < nums[mid + 1]) {
        L = L + 1;
        continue;
      }
    }
    return rs;
  }
}