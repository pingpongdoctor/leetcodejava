// 230. Kth Smallest Element in a BST
// use dfs to interpret inorder traversal
// utilize a count variable to globally track the number of node that have been visited
class KSmallestTreeNode {
    int ans = 0;
    int count;

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        count--;
        if (count == 0) {
            ans = root.val;
            return;
        }
        dfs(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return ans;
    }
}