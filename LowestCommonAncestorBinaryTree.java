// 236. Lowest Common Ancestor of a Binary Tree
// DFS
// return nodes when traverse to the right and left
// if two nodes on the same subtree, one node is null, then return root
// if two nodes are on different subtrees, both of them are not null, then return the not null node
public class LowestCommonAncestorBinaryTree {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left != null && right != null) {
      return root;
    }

    return left == null ? right : left;
  }
}
