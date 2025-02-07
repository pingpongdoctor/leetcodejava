// 112. Path Sum
// DFS solution
// Check if sum equals to target and the current node is the leaf node to return true
class PathSum {
    private boolean dfs(TreeNode node, int targetSum, int sum) {
        if (node == null) {
            return false;
        }

        sum += node.val;
        if (sum == targetSum && node.left == null && node.right == null) {
            return true;
        }
        return dfs(node.left, targetSum, sum) || dfs(node.right, targetSum, sum);

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return dfs(root, targetSum, 0);
    }
}