// 283. Move Zeroes
//Use L to memorize the 0 value and R to look for the non zero value then swap L and R when non zero value is found when looping
public class MoveZeroes {
  public void moveZeroes(int[] nums) {
    int L = 0;
    int R = 0;
    while (R < nums.length) {
      if (nums[R] != 0) {
        int temp = nums[R];
        nums[R] = nums[L];
        nums[L] = temp;
        L++;
      }
      R++;
    }
  }
}