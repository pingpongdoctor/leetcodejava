// 1318. Minimum Flips to Make a OR b Equal to c
// Solve the right most bits of a,b and c as the base case then come up with other bigger problems to the left
// Bit manipulation solution
public class MinimumFlipsMakeAOrBEqualC {
  public int minFlips(int a, int b, int c) {
    int flip = 0;
    while (a > 0 || b > 0 || c > 0) {
      // use & 1 to isolate LSB (least significant bit)
      int bitA = a & 1;
      int bitB = b & 1;
      int bitC = c & 1;
      if (bitC == 0) {
        if (bitA == 1 && bitB == 1) {
          flip += 2;
        } else if (bitA == 1 || bitB == 1) {
          flip += 1;
        }
      } else {
        if (bitA == 0 && bitB == 0) {
          flip += 1;
        }
      }
      // move to the right 1 bit to process the next LSB (110 -> 11)
      a >>= 1;
      b >>= 1;
      c >>= 1;
    }
    return flip;
  }
}