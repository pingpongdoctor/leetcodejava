class Solution {
  public boolean dfs(TreeNode root, int targetSum, int curSum) {
      if(root==null){
          return false;
      }
      curSum=curSum+root.val;
      if(root.left==null&&root.right==null&&curSum==targetSum){
          return true;
      }
      return dfs(root.left, targetSum, curSum)||dfs(root.right, targetSum, curSum);
  }

  public boolean hasPathSum(TreeNode root, int targetSum) {
      return dfs(root,targetSum,0);
  }
}