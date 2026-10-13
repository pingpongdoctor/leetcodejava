/**
Time complexity: O(n*2^n)
Space complexity: O(n*2^n)
*/

public class Leetcode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        helper(result, nums, -1, path);

        return result;
    }

    private void helper(List<List<Integer>> result, int[] nums, int idx, List<Integer> path) {
        if(idx >= nums.length) {
            return;
        }

        result.add(new ArrayList(path));

        for(int i = idx + 1; i < nums.length; i++) {
            path.add(nums[i]);
            helper(result, nums, i, path);
            path.remove(path.size() - 1);
        }
    }
}