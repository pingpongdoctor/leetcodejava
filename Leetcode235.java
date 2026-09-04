/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

 Solution: Using the nature of BST. We look for p and q by comparing their values with root. As soon as we find the node that is included in the range of p and q values or the node that is either the alias of p or the alias of q, we return that node.
 Time complexity: O(logn), worst case is O(n)
 Space complexity: O(1)
 */

public class Leetcode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if(root == p || root == q) {
                return root;
            }
            if(root.val < p.val && root.val > q.val) {
                return root;
            }
            if(root.val < q.val && root.val > p.val) {
                return root;
            }
            if(root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }
}