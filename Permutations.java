import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
     private void dfs(int[] nums, Set<Integer> visit, List<Integer> temp, List<List<Integer>> ans){
        if(temp.size()==nums.length){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = 0; i<nums.length; i++){
            if(visit.contains(i)){
                continue;
            }
            temp.add(nums[i]);
            visit.add(i);
            dfs(nums,visit,temp,ans);
            temp.remove(temp.size()-1);
            visit.remove(i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        dfs(nums,visit,temp,ans);
        return ans;
    }
}
