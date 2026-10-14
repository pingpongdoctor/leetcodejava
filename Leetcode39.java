/**
Solution: use backtracking to track all valid path from each elements. Since we are finding unique combination, each recursive function invocation should interate forward from the current index.

Time complexity: O(n^t/m + k*t/m) which is the sum of time taken for dfs and time taken for creating copy. t/m is the height of tree (target/smallest element). Each level, we branch into n path at most so for t/m level, it is n^t/m. Each path has t/m elements at most so k valid path take k*t/m time.
Space complexity: O(t/m + k*t/m) which is the sum of space taken for call stack and space taken for result list.
*/

public class Leetcode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, path, result, 0, 0);
        return result;
    }

    private void helper(int[] candidates, int target, List<Integer> path, List<List<Integer>> result, int sum, int idx) {
        if (sum > target) {
            return;
        }

        if(sum == target) {
            result.add(new ArrayList(path));
            return;
        }

        for(int i = idx; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, target, path, result, sum + candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}