public /**
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

 Pick the middle value of the list as the current root node of the tree, then build the left and the right subtree by recursively calling the preorder traversal function on each subtree.
 Time complexity: O(n)
 Space complexity: O(h)
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(0, nums.length - 1, nums);
    }
    private TreeNode buildTree(int l, int r, int[] nums) {
        if(l > r) {
            return null;
        }

        int mid = l + (r-l)/2;
        TreeNode cur = new TreeNode(nums[mid]);

        cur.left = buildTree(l, mid - 1, nums);
        cur.right = buildTree(mid + 1, r, nums);

        return cur;
    }
} {
    
}
