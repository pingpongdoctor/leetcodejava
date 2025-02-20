import java.util.ArrayList;
import java.util.List;

// 39. Combination Sum
//Since unique combination subsets have duplicate elements so we use target to track if sum is greater than target
//Substract current sum from target, if target == 0, it does mean that sum == target
//Only increment start index when recursively solve the right subtree
class CombinationSum {
    private void dfs(int[] candidates, int target, List<Integer> temp, List<List<Integer>> ans, int cur, int idx){
        if(cur>target){
            return;
        }
        if(cur == target){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int i = idx; i<candidates.length; i++){
            temp.add(candidates[i]);
            dfs(candidates,target,temp,ans,cur+candidates[i],i);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(candidates,target,temp,ans,0,0);
        return ans;
    }
}