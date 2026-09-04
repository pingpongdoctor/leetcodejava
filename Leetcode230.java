import java.util.ArrayDeque;

import javax.swing.tree.TreeNode;

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
 Solution 1: Use inorder DFS to traverse through nodes in an ascending order of values. Everytime a node that is not null is processed, we increment count by 1. When count == k, we update result.
 With solution 1, we need to use the instance variable to retrieve the result and count variable to keep counting the nodes that are processed. By doing this, we do not have to deal with the inconsistency of value that is passed down to the recursive function calls.

Time complexity: O(n) (in worst scenario, k is equal to n)
Space complexity: O(h) since the stack include the maximum number of function that is equal to the height of the tree

 Solution: Inorder traverse using explicit stack. Use a while loop to traverse through the tree and use the stack to store nodes that are processed in a reverse order to access the nodes in the left subtree first. Everytime we process a node by poping it from the stack, we decrement k by 1. As soon as k is 0, we return the node value.
 */
 
public class Leetcode230 {
    private int result = -1;
    private int count = 0;

    private void traverse(TreeNode root, int k) {
        if(root == null) {
            return;
        }

        traverse(root.left, k);

        count++;
        if (count == k) {
            this.result = root.val;
        }

        traverse(root.right,k);
    }

    public int kthSmallest(TreeNode root, int k) {
        if(root.left == null && root.right == null) {
            return root.val;
        }

        traverse(root,k);

        return result;
    }

    public int kthSmallest2(TreeNode root, int k) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()) {
                root = stack.pop();
                k--;
                if(k == 0) {
                    return root.val;
                }
            }

            root = root.right;
        }

        return -1;
    }
}