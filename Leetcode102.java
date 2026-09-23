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
 * Time complexity:
 * Space compexity:
 * 
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        ArrayDeque<TreeNode> myQueue = new ArrayDeque<>();
        myQueue.offer(root);

        while(!myQueue.isEmpty()) {
            List<Integer> element = new ArrayList<>();
            int size = myQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = myQueue.poll();
                if(cur.left != null) {
                    myQueue.offer(cur.left);
                }
                if(cur.right != null) {
                    myQueue.offer(cur.right);
                }
                element.add(cur.val);
            }
            result.add(element);
        }
        return result;
    }
}