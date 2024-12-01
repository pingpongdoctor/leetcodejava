// 136. Single Number
// XOR solution
// XOR is commutative and associative so order is not important
// n XOR 0 results n and n XOR n results 0 so at the end we can find the element that is not duplicate

public class SingleNumber {
  public int singleNumber(int[] nums) {
    int ans = 0;
    for (int n : nums) {
      ans ^= n;
    }
    return ans;
  }
}