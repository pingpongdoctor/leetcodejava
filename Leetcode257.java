/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * Solution 1: Use dfs to search for leaf node. If we are at the leaf node, add the current path to the result array. Use backtracking to track different paths effectively
 Time compexity: O(n + l*h)
 Space compelxity: O(l*h)
 */

public class Leetcode257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        helper(root, path, result);
        List<String> resultString = new ArrayList(result.size());

        for(List<Integer> ele : result) {
            StringBuilder ans = new StringBuilder();
          for (int i = 0; i < ele.size(); i++) {
                if (i > 0) {
                    ans.append("->");
                }
                ans.append(ele.get(i));
            }
            resultString.add(ans.toString());
        }
        return resultString;

    }
    private void helper(TreeNode root, List<Integer> path, List<List<Integer>> result) {
        if(root.left == null && root.right == null) {
            path.add(root.val);
            result.add(new ArrayList(path));
            path.remove(path.size() - 1);
            return;
        }

        if(root.left != null) {
            path.add(root.val);
            helper(root.left, path, result);
            path.remove(path.size() - 1);
        }

        if(root.right != null) {
            path.add(root.val);
            helper(root.right, path, result);
            path.remove(path.size() - 1);
        }
    }
}