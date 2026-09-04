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
 Solution: using BFS to search each level from left to right and check the inner loop control variable value to see if we reach the last node which is also the right most node that can be seen on the right side.

 Time complexity: O(n)
 Space complexity: O(w + h) with w is the maximum width of the tree across any level and h is the height which stands for the maximum number of nodes that can be stored in the result list
 */
public class Leetcode199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
                if(i == size - 1) {
                    result.add(cur.val);
                }
            }
        }

        return result;
    }
}