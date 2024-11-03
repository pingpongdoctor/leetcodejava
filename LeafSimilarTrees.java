import java.util.ArrayList;
import java.util.List;

// 872. Leaf-Similar Trees
//DFS solution using post order traversal
public class LeafSimilarTrees {
  private void dfs(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    dfs(root.left, result);
    if (root.left == null & root.right == null) {
      result.add(root.val);
    }
    dfs(root.right, result);
    if (root.left == null & root.right == null) {
      result.add(root.val);
    }
  }

  private List<Integer> getLastNodeValue(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    dfs(root, result);
    return result;
  }

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> result1 = getLastNodeValue(root1);
    List<Integer> result2 = getLastNodeValue(root2);
    if (result1.size() != result2.size()) {
      return false;
    }
    for (int i = 0; i < result1.size(); i++) {
      if (!result1.get(i).equals(result2.get(i))) {
        return false;
      }
    }
    return true;
  }
}