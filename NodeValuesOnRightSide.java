import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 199. Binary Tree Right Side View
class NodeValuesOnRightSide {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
  public List<Integer> rightSideView(TreeNode root) {
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      List<Integer> valueOnRightSide = new ArrayList<Integer>();

      if(root==null){
          return valueOnRightSide;
      }

      queue.add(root);
      while(!queue.isEmpty()){
          TreeNode rightMostNode = null;//get the valu on the right of each level
          int levelSize = queue.size();
          for(int i=0; i<levelSize; i++){//each iteration looping through nodes in each level from left to right
              TreeNode cur = queue.remove();
              rightMostNode = cur;
              if(cur.left!=null){
                  queue.add(cur.left);
              }
              if(cur.right!=null){
                  queue.add(cur.right);
              }
          }
          valueOnRightSide.add(rightMostNode.val); 
      }
      return valueOnRightSide;
  }
}