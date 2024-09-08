import java.util.ArrayList;
import java.util.List;

class Subsets {
  private List<Integer> subset = new ArrayList<Integer>();
  private List<List<Integer>> res = new ArrayList<List<Integer>>();

  private void backTrack(
      int start,
      int[] nums) {
      if(start>=nums.length){
          res.add(new ArrayList<>(subset));
          return;
      }

      subset.add(nums[start]);
      backTrack(start+1,nums);
      subset.remove(subset.size()-1);
      backTrack(start+1,nums);
  }

  public List<List<Integer>> subsets(int[] nums) {
      backTrack(0,nums);
      return res;
  }
}