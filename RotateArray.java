import java.util.ArrayDeque;
import java.util.Deque;

//189. Rotate Array
public class RotateArray {
  // use deque
  public void rotate(int[] nums, int k) {
    k = k % nums.length;
    Deque<Integer> stack = new ArrayDeque<>();
    for (Integer n : nums) {
      stack.addLast(n);
    }
    while (k > 0) {
      int tmp = stack.removeLast();
      stack.addFirst(tmp);
      k--;
    }
    int i = 0;
    while (!stack.isEmpty()) {
      nums[i] = stack.removeFirst();
      i++;
    }
  }

  // reverse method to save memory
  private void reverse(int[] arr, int l, int r) {
    while (l < r) {
      int tmp = arr[l];
      arr[l] = arr[r];
      arr[r] = tmp;
      l++;
      r--;
    }
  }

  public void rotate2(int[] nums, int k) {
    k = k % nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }
}