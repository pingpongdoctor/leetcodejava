// 136. Single Number
// XOR solution
// XOR is commutative and associative so order is not important
// n XOR 0 results n and n XOR n results 0 so at the end we can find the element that is not duplicate
// Input: [1, 2, 3, 2, 3], initial ans = 0
// XOR combines ans with each number in the array:
// - First pass through 1, 2, and 3 adds them to ans since ans XOR 0 = the number itself.
// - When 2 and 3 appear again, XOR removes them from ans because n XOR n = 0 (cancels out pairs).
// - In the end, only the unique number (1) remains in ans.

public class SingleNumber {
  public int singleNumber(int[] nums) {
    int ans = 0;
    for (int n : nums) {
      ans ^= n;
    }
    return ans;
  }
}