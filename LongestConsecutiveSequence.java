import java.util.HashSet;
import java.util.Set;

// 128. Longest Consecutive Sequence
// for returning the number of values in the logest sequence, we use set to store values and check n - 1
// if n - 1 is available in the set, it is not the first value in a sqeuence
// Otherwise, we check to see how many larger consecutive values using an inner while loop
// The Time Complexity is O(3n) (take n steps to add numbers to set, maximum 2n steps to access elements using for and nested while loop)
public class LongestConsecutiveSequence {
  public int longestConsecutive(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    Set<Integer> set = new HashSet<>();

    for (int n : nums) {
      set.add(n);
    }

    int max = 1;

    for (int n : set) {
      if (!set.contains(n - 1)) {
        int size = 1;
        int val = n + 1;
        while (set.contains(val)) {
          size++;
          val++;
        }
        max = Math.max(max, size);
      }
    }

    return max;
  }
}