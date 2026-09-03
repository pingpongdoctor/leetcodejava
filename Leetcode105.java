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

 check root value in inorder. Since the left and right nodes of the node that has the value equivalent to the root value are the nodes of left and right subtrees respectively, we can recursively call the function to access each side of the current node and build the tree

 [3,9,20,15,7] pre
  0 1  2  3 4
 [9,3,15,20,7] in



Global shared pointer (instance variable)
form a map that store values in inorder array and their index
current function call
helper(2,4)
preIdx = 1
base case
right > left 

cur value that gets from the preorder
cur = 20
look 20 in inorder array using the hashmap and return the index
index found
index = 3
create a new node at the current iteration
TreeNode newNode = TreeNode(20)
increment preIdx before recuresively calling the helper function
pre++

root.left = helper(2, 2)
root.right = helper(4, 4)

        3
    9       20
        15      7

return root

time complexity O(n)
space complexity 0(n + h)
 */
public class Leetcode105 {
    private int preIdx = 0;
    private HashMap<Integer,Integer> map = new HashMap<>();

    private TreeNode helper(int[] preorder, int left, int right) {
        if(right < left) {
            return null;
        }

        int cur = preorder[preIdx];
        int inorderIdx = map.get(cur);
        TreeNode root = new TreeNode(cur);

        preIdx++;

        root.left = helper(preorder, left, inorderIdx - 1);
        root.right = helper(preorder, inorderIdx + 1, right);

        return root;
        
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length - 1);
    }
}