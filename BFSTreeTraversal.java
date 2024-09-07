import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// 102. Binary Tree Level Order Traversal
class BFSTreeTraversal {
  public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> list = new ArrayList<List<Integer>>();
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      if(root!=null){
          queue.add(root);
      }
      while(!queue.isEmpty()){
          int levelLength = queue.size();
          List<Integer> curLevelNodeVals = new ArrayList<Integer>();
          for(int i = 0; i<levelLength; i++){
              TreeNode cur = queue.remove();
              curLevelNodeVals.add(cur.val);
              if(cur.left!=null){
                  queue.add(cur.left);
              }
              if(cur.right!=null){
                  queue.add(cur.right);
              }
          }
          if(curLevelNodeVals.isEmpty()==false){
              list.add(curLevelNodeVals);
          }
          
      }
      return list;
  }
}