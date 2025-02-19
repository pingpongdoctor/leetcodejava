// 77. Combinations

import java.util.ArrayList;
import java.util.List;

// 77. Combinations
public class Combinations {
     private void backtracking(List<List<Integer>> ans, List<Integer> temp, int n, int val, int k){
        if(temp.size()==k){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        if(val>n){
            return;
        }
        for(Integer i = val; i<=n; i++){
            temp.add(i);
            backtracking(ans,temp,n,i+1,k);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtracking(ans,temp,n,1,k);
        return ans;
    }
}
