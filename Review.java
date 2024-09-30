import java.util.LinkedList;
import java.util.Queue;

public class Review {
  //review mergSort
  //logn
  //stable
  private void mergeS(int[] list, int l, int r){
    if(l<r){
      int m =(l+r)/2;
      mergeS(list,l,m);
      mergeS(list,m+1,r);
      merge(list,l,m,r);
    }
  }
  private void merge(int[] list,int l,int m,int r){
    int[] list1 = new int[m-l+1];
    int[] list2 = new int[r-m];

    for(int i=0; i<list1.length;i++){
      list1[i]=list[i+l];
    }
    for(int i=0; i<list2.length;i++){
      list2[i]=list[i+m+1];
    }

    int i = 0;
    int k = 0;
    int j = 0;

    while(k<list1.length&&j<list2.length){
      if(list1[k]<list2[j]){
        list[l+i]=list1[k];
        k++;
      }else{
        list[l+i]=list2[j];
        j++;
      }
      i++;
    }

    while(k<list1.length){
      list[l+i]=list1[k];
      k++;
      i++;
    }

    while(j<list2.length){
      list[l+i]=list2[j];
      j++;
      i++;
    }
  }
  public int[] mergeSort(int[] list){
    mergeS(list,0,list.length-1);
    return list;
  }

  //review insertion sort
  //n2
  //stable
  public int[] insertionSort(int[] list){
    for(int i = 1; i<list.length; i++){
      int j = i - 1;
      while(j>=0&&list[j]>list[j+1]){
        int tmp = list[j-1];
        list[j-1]=list[j];
        list[j]=tmp;
        j--;
      }
    }
    return list;
  }

  //review quick sort
  public int[] quickSort(int[] list,int s,int e){
    if(e<=s){
      return list;//skip sorting if there is less than or equal to 1 element
    }
    int l = s;//create a copy of start index
    int pivot = list[e];//get the pivot

    for(int i = s; i<e; i++){
      if(list[i]<pivot){
        int tmp = list[l];
        list[l] = list[i];
        list[i ]= tmp;
        l++;
      }
    }
    list[e] = list[l];
    list[l] = pivot;
    quickSort(list,s,l-1);
    quickSort(list,l+1,e);
    return list;
  }
  //review bucket sort
  public int[] bucketSort(int[] list){
    if(list.length<=1){
      return list;
    }
    int[] count = {0,0,0};
    //loop to count numbers of duplicate values in lists
    for(int i = 0;i<list.length;i++){
      count[list[i]]++;
    }
    
    int i=0;
    //loop to access values (index of count is value and value at each index of count is the frequency of value)
    for(int j = 0;j<count.length;j++){
      //loop to get the number of times to add value
      for(int k = 0; k<count[j]; k++){
        list[i]=j;
        i++;
      }
    }
    return list;
  }

  //review binary search tree
  public boolean searchTargetInBinarySearchTree(TreeNode root, int target){
    if(root==null){
      return false;
    }

    if(root.val<target){
      return searchTargetInBinarySearchTree(root.right, target);
    } else if(root.val>target){
      return searchTargetInBinarySearchTree(root.left, target);
    } else {
      return true;
    }
  }

  //review insert and remove node in BST
  public TreeNode insertTreeNode(TreeNode root, int val){
    if(root == null){
      return new TreeNode(val);
    }
    if(val<root.val){
      root.left=insertTreeNode(root.left, val);
    }else if(
      val>root.val
    ){
      root.right=insertTreeNode(root.right, val);
    }
    return root;
  }

  public TreeNode removeTreeNode(TreeNode root, int val){
    if(root==null){
      return null;
    }

    if(val>root.val){
      root.right = removeTreeNode(root.right,val);
    }else if(val<root.val){
      root.left = removeTreeNode(root.left, val);
    } else{
      if(root.right==null){
        return root.left;
      }else if(root.left==null){
        return root.right;
      }else{
        TreeNode minTreeNode = minNode(root.right);
        root.val=minTreeNode.val;
        root.right=removeTreeNode(root.right, minTreeNode.val);
      }
    }
    return root;
  }

  public TreeNode minNode(TreeNode root){
    TreeNode cur = root;
    while(cur!=null&&cur.left!=null){
      cur=cur.left;
    }
    return cur;
  }

  //review DFS
  //pre-order
  public void preOrderTraversal(TreeNode root){
    if(root==null){
      return;
    }
    System.out.println(root.val);
    preOrderTraversal(root.left);
    preOrderTraversal(root.right);
  }

  //review BFS
  //add root to queue
  //first loop checks if queue is not empty
  //second loop print out all values of nodes in the current values and add add nodes in the next level to queue
  public void implementBFS(TreeNode root){
    Queue<TreeNode> queue = new LinkedList<TreeNode>();

    if(root!=null){
      queue.add(root);
    }
    while(!queue.isEmpty()){
      int curLevelSize = queue.size();
      for(int i = 0;i<curLevelSize;i++){
        TreeNode cur = queue.remove();
        System.out.println(cur.val);
        if(cur.right!=null){
          queue.add(cur.right);
        }
        if(cur.left!=null){
          queue.add(cur.left);
        }
      }
    }
  }

  //review treemaze
  public boolean isTherePath(TreeNode root){
    if(root==null||root.val==0){return false;}
    if(root.left==null&&root.right==null){
      return true;
    }
    if(isTherePath(root.left)){
      return true;
    }
    if(isTherePath(root.right)){
      return true;
    }
    return false;
  }

  //Matrix DFS
  //look unique paths of value 0 nodes
  public int matrixDFS(int[][]grid, int[][]visit, int r, int c){
    int rows = grid.length;
    int cols = grid[0].length;
    //base cases
    if(
      //coordinate outbound of grid
      Math.min(r,c)<0||r==rows||c==cols||
      //we reach the visited coordinate
      visit[r][c]==1 ||
      //we reach the node with value 1
      grid[r][c]==1
    ){
      return 0;
    }
    //if we does not reach the base case above, memmorize the visited coordinate
    visit[r][c]=1;
    //traverse in 4 directions
    int count = 0;
    count += matrixDFS(grid, visit, r+1, c);
    count += matrixDFS(grid, visit, r-1, c);
    count += matrixDFS(grid, visit, r, c+1);
    count += matrixDFS(grid, visit, r, c-1);
    //delete visited coordinates when we backtrack since we want these coordinates can be visited again in other directions
    visit[r][c]=0;
    return count;
  }
}