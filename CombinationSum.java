import java.util.ArrayList;
import java.util.List;

// 39. Combination Sum
//Since unique combination subsets have duplicate elements so we use target to track if sum is greater than target
//Substract current sum from target, if target == 0, it does mean that sum == target
//Only increment start index when recursively solve the right subtree
class CombinationSum {
  private List<List<Integer>> res = new ArrayList<List<Integer>>();
  private List<Integer> subset = new ArrayList<Integer>();

  private void backTrack(int start, int[] candidates, int target){
      if(target==0){
          res.add(new ArrayList<>(subset));
          return;
      } else if(target<0||start>=candidates.length){
          return;
      }
      subset.add(candidates[start]);
      backTrack(start, candidates, target - candidates[start]);
      subset.remove(subset.get(subset.size()-1));
      backTrack(start + 1, candidates, target);
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
      backTrack(0, candidates, target);
      return res; 
  }
}