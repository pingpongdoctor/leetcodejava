// 790. Domino and Tromino Tiling
//bottom up solution
public class DominoTrominoTiling {
  public int numTilings(int n) {
    int mod = (int) Math.pow(10, 9) + 7;
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    if (n == 3) {
      return 5;
    }
    int[] ways = { 1, 2, 5 };
    for (int i = 4; i <= n; i++) {
      int temp1 = ways[1];
      int temp2 = ways[2];
      ways[2] = (ways[2] * 2 % mod + ways[0]) % mod;
      ways[0] = temp1;
      ways[1] = temp2;
    }
    return ways[ways.length - 1] % mod;
  }
}