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

 Time complexity: O(n)
 Space complexity: O(h)
 */
public class Leetcode124 {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = Math.max(dfs(root.left),0);
        int right = Math.max(dfs(root.right),0);
        
        ans = Math.max(ans, root.val + left + right);

        return root.val + Math.max(left, right);
    }
}