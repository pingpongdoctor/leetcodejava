//Leetcode 75
//Bucket sort
public class SortColors {
  public void sortColors(int[] nums) {
      int[] counts = new int[3];

      for(int i = 0; i<nums.length; i++){
          counts[nums[i]]++;
      }

      int i = 0;//track places to insert in original array

      for(int n = 0; n<counts.length; n++){
          for(int j = 0; j<counts[n];j++){
              nums[i]=n;
              i++;
          }
      }
  }
}
