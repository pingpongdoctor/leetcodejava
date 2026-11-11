import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

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
 Time complexity: O(n)
 Space complexity: O(n)
 */
public class Leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        //1 is l->r and 2 is r->l
        int direction = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);

                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                    if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            if(direction == 2) {
                Collections.reverse(list);
            }

            result.add(list);
            direction = direction == 1 ? 2 : 1;
        }

        return result;
    }
}