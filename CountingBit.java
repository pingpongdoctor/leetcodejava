public class CountingBit {
  // manually calculate bit representation
  public int[] countBits(int n) {
    int[] ans = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      int m = i;
      while (m > 0) {
        if (m % 2 == 1) {
          ans[i]++;
        }
        m = m / 2;
      }
    }
    return ans;
  }

  // use bit manipulation to gradually delete the least significant 1 from the
  // current bit by using bitwise operater & for n and n-1
  private int helper(int n) {
    int count = 0;
    while (n > 0) {
      n = n & (n - 1);
      count++;
    }
    return count;
  }

  public int[] countBits2(int n) {
    int[] ans = new int[n + 1];
    for (int i = 1; i < n + 1; i++) {
      ans[i] = helper(i);
    }
    return ans;
  }
}