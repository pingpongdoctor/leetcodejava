import java.util.ArrayList;

//236. Lowest Common Ancestor of a Binary Tree
//Use DFS to traverse to find the paths to two nodes
//Use array list to save paths
//Compare two lists to find the first different node in two path and return the node before which is the lowest common ancestor
public class LowestCommonAncestorBinaryTree {
  private boolean dfs(TreeNode root, ArrayList<TreeNode> ans, TreeNode target) {
    if (root == null) {
      return false;
    }
    ans.add(root);
    if (root == target) {
      return true;
    }
    if (dfs(root.left, ans, target) || dfs(root.right, ans, target)) {
      return true;
    }
    ans.remove(ans.size() - 1);
    return false;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    ArrayList<TreeNode> ans1 = new ArrayList<>();
    ArrayList<TreeNode> ans2 = new ArrayList<>();
    dfs(root, ans1, p);
    dfs(root, ans2, q);
    int i = 0;
    while (i < ans1.size() && i < ans2.size()) {
      if (ans1.get(i) != ans2.get(i)) {
        break;
      }
      i++;
    }
    return ans1.get(i - 1);
  }
}
