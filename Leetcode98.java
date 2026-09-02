import java.util.ArrayDeque;

import javax.swing.tree.TreeNode;

public /**
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
 */
public class Leetcode98 {
    
    private ArrayDeque<TreeNode> stack = new ArrayDeque<>();
    private TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);

        if (prev != null && prev.val >= root.val) { return false;}

        prev = root;

        boolean right = isValidBST(root.right);

        return left && right;
    }

    public boolean isValidBST2(TreeNode root) {
        if(root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);

        if (prev != null && prev.val >= root.val) { return false;}

        prev = root;

        boolean right = isValidBST(root.right);

        return left && right;
    }
} {
    
}
