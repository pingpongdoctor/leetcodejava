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
 Time complexity: O(nc) to construct all nodes with c is the number of subtree and n is the numbder of node in a subtree
 Space compelxity: O(nc) to reserve space for all nodes nodes
 */
 
public class Leetcode95 {
    public List<TreeNode> generateTrees(int n) {
        return buildTree(1, n);
    }

    private List<TreeNode> buildTree(int l, int r) {
        List<TreeNode> result = new ArrayList<>();

        if(l > r) {
            result.add(null);
            return result;
        }

        for(int i = l; i <= r; i++) {
            List<TreeNode> leftList = buildTree(l, i - 1);
            List<TreeNode> rightList = buildTree(i + 1, r);
            for(TreeNode left : leftList) {
                for(TreeNode right: rightList) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    result.add(cur);
                }
            }
        }

        return result;
    }
}