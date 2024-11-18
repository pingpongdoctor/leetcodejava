// 1137. N-th Tribonacci Number
//bottom-up DP solution to break a problem into subproblem
public class NthTribonacciNumber {
  public int tribonacci(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return 1;
    }
    int[] rs = { 0, 1, 1 };
    for (int i = 3; i <= n; i++) {
      int temp1 = rs[1];
      int temp2 = rs[2];
      rs[2] = rs[0] + rs[1] + rs[2];
      rs[0] = temp1;
      rs[1] = temp2;
    }
    return rs[2];
  }
}
