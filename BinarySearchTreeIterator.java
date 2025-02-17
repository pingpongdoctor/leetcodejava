import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 173. Binary Search Tree Iterator
// queue with dfs solution
// inorder traverse the BST and store values in a queue
// poll the peek value in next method and return it when calling next function
// return queue.size() when executing hasNext function
// This solution works even the tree is not a BST
// with stack solution, we use stack to track all left nodes
// pop the stack to get the most left node and return value
// check if the popped node has an available right node
// if yes, add the right node and traverse to the left of it to add left most nodes to the stack
// by doing this, we can break inorder traversal into next and hasnext functions
public class BinarySearchTreeIterator {
  Queue<Integer> queue;
  Stack<TreeNode> stack;

  private void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    dfs(root.left);
    queue.add(root.val);
    dfs(root.right);
  }

  public BinarySearchTreeIterator(TreeNode root) {
    // queue and dfs solution
    queue = new LinkedList<>();
    dfs(root);
    // stack solution without dfs
    stack = new Stack<>();
    fillStack(root);
  }

  // queue solution
  public int next() {
    return queue.poll();
  }

  public boolean hasNext() {
    return queue.size() > 0;
  }

  //stack solution
  public int next2() {
    TreeNode cur = stack.pop();
    if (cur.right != null) {
      fillStack(cur.right);
    }
    return cur.val;
  }

  public boolean hasNext2() {
    return stack.size() > 0;
  }

  private void fillStack(TreeNode node) {
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }
}
