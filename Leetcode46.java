/**
Solution: Backtrack to track different paths. Allow traversing backward from the current index when building the paths. Use set to avoid adding duplicate elements to the path.
Time complexity: O(n! * n) n! the number of calls contributes to a constant multiplied by n! which is the permutations as well as the number of leaf nodes. At each permutation, we copy n element from path to create a new list added to the result, which take n time.
Space complexity: O(n + n*n!) n is the space reserved for the call stack and n*n! is the space reserved for the result list
*/

public class Leetcode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            path.add(nums[i]);
            set.add(nums[i]);
            helper(nums, set, path, result, i);
            path.remove(path.size() - 1);
            set.remove(nums[i]);
        }

        return result;
    }
    private void helper(int[] nums, HashSet<Integer> set, List<Integer> path, List<List<Integer>> result, int idx) {
        if(path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                continue;
            }

            path.add(nums[i]);
            set.add(nums[i]);
            helper(nums, set, path, result, i);
            path.remove(path.size() - 1);
            set.remove(nums[i]);
        }
    }
}