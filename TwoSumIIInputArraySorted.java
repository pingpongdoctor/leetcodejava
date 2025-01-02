// 167. Two Sum II - Input Array Is Sorted
// two pointers
public class TwoSumIIInputArraySorted {
  public int[] twoSum(int[] numbers, int target) {
    int L = 0;
    int R = numbers.length - 1;
    while (L < R) {
      if (numbers[L] + numbers[R] < target) {
        L++;
      } else if (numbers[L] + numbers[R] > target) {
        R--;
      } else {
        break;
      }
    }
    int[] ans = { L + 1, R + 1 };
    return ans;
  }
}