// 202. Happy Number
// Write an algorithm to determine if a number n is happy.

// A happy number is a number defined by the following process:

// Starting with any positive integer, replace the number by the sum of the squares of its digits.
// Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
// Those numbers for which this process ends in 1 are happy.
// Return true if n is a happy number, and false if not.

// fast and slow pointers solution

import java.util.HashSet;
import java.util.Set;

// 202. Happy Number
public class HappyNumber {
  private int squareFc(int num) {
    int ans = 0;
    while (num > 0) {
      int remainder = num % 10;
      ans += remainder * remainder;
      num /= 10;
    }
    return ans;
  }

  // hashset solution
  public boolean isHappy(int n) {
    if (n == 1) {
      return true;
    }

    Set<Integer> set = new HashSet<>();

    while (!set.contains(squareFc(n))) {
      n = squareFc(n);

      if (n == 1) {
        return true;
      }

      set.add(n);
    }

    return false;
  }

  // fast and slow pointers solution
  public boolean isHappy2(int n) {
    if (n == 1) {
      return true;
    }

    int slow = n;
    int fast = n;

    while (true) {
      slow = squareFc(slow);
      fast = squareFc(squareFc(fast));

      if (slow == 1 || fast == 1) {
        return true;
      }

      if (slow == fast) {
        break;
      }
    }

    return false;
  }
}
