import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 103. Binary Tree Zigzag Level Order Traversal
// BFS and store values at each level in a list
// reverse the list using Collections class's reverse method to reverse the list if the current traversed level is an odd number
public class BinaryTreeZigzagLevelOrderTraversal {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }

    if (root.left == null && root.right == null) {
      List<Integer> newList = new ArrayList<>();
      newList.add(root.val);
      ans.add(newList);
      return ans;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int level = 0;
    while (queue.size() > 0) {
      int size = queue.size();
      List<Integer> list = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        list.add(cur.val);
        if (cur.left != null) {
          queue.add(cur.left);
        }
        if (cur.right != null) {
          queue.add(cur.right);
        }
      }
      if (level % 2 == 1) {
        Collections.reverse(list);
      }
      ans.add(list);
      level++;
    }
    return ans;
  }
}
