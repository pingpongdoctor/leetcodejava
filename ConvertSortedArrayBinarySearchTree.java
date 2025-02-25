// 108. Convert Sorted Array to Binary Search Tree
// DFS to build the mid node and return it at every level of the tree
public class ConvertSortedArrayBinarySearchTree {
    private TreeNode helper(int[] nums, int left, int right){
        if (left > right){
            return null;
        }
        int mid = left +  (right - left) / 2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root; 
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
}
