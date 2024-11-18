import java.util.ArrayList;
import java.util.List;

// 216. Combination Sum III
// Using DFS and Backtracking
public class CombinationSumIII {
  private void dfs(int num, int sum, List<Integer> res, List<List<Integer>> ans, int k, int n) {
    if (sum > n || res.size() > k) {
      return;
    }
    if (sum == n && res.size() == k) {
      ans.add(new ArrayList<>(res));
      return;
    }
    for (int i = num; i <= 9; i++) {
      sum += i;
      res.add(i);
      dfs(i + 1, sum, res, ans, k, n);
      sum -= i;
      res.remove(res.size() - 1);
    }
  }

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> res = new ArrayList<>();
    dfs(1, 0, res, ans, k, n);
    return ans;
  }
}
