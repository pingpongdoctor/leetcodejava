import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Review {
  // review mergSort
  // logn
  // stable
  private void mergeS(int[] list, int l, int r) {
    if (l < r) {
      int m = (l + r) / 2;
      mergeS(list, l, m);
      mergeS(list, m + 1, r);
      merge(list, l, m, r);
    }
  }

  private void merge(int[] list, int l, int m, int r) {
    int[] list1 = new int[m - l + 1];
    int[] list2 = new int[r - m];

    for (int i = 0; i < list1.length; i++) {
      list1[i] = list[i + l];
    }
    for (int i = 0; i < list2.length; i++) {
      list2[i] = list[i + m + 1];
    }

    int i = 0;
    int k = 0;
    int j = 0;

    while (k < list1.length && j < list2.length) {
      if (list1[k] < list2[j]) {
        list[l + i] = list1[k];
        k++;
      } else {
        list[l + i] = list2[j];
        j++;
      }
      i++;
    }

    while (k < list1.length) {
      list[l + i] = list1[k];
      k++;
      i++;
    }

    while (j < list2.length) {
      list[l + i] = list2[j];
      j++;
      i++;
    }
  }

  public int[] mergeSort(int[] list) {
    mergeS(list, 0, list.length - 1);
    return list;
  }

  // review insertion sort
  // n2
  // stable
  public int[] insertionSort(int[] list) {
    for (int i = 1; i < list.length; i++) {
      int j = i - 1;
      while (j >= 0 && list[j] > list[j + 1]) {
        int tmp = list[j + 1];
        list[j + 1] = list[j];
        list[j] = tmp;
        j--;
      }
    }
    return list;
  }

  // review quick sort
  public void quickSort(int[] list, int s, int e) {
    if (e <= s) {
      return;// skip sorting if there is less than or equal to 1 element
    }
    int l = s;// create a copy of start index
    int pivot = list[e];// get the pivot

    for (int i = s; i < e; i++) {
      if (list[i] < pivot) {
        int tmp = list[l];
        list[l] = list[i];
        list[i] = tmp;
        l++;
      }
    }
    list[e] = list[l];
    list[l] = pivot;
    quickSort(list, s, l - 1);
    quickSort(list, l + 1, e);
  }

  // review bucket sort
  public int[] bucketSort(int[] list) {
    if (list.length <= 1) {
      return list;
    }
    int[] count = { 0, 0, 0 };
    // loop to count numbers of duplicate values in lists
    for (int i = 0; i < list.length; i++) {
      count[list[i]]++;
    }

    int i = 0;
    // loop to access values (index of count is value and value at each index of
    // count is the frequency of value)
    for (int j = 0; j < count.length; j++) {
      // loop to get the number of times to add value
      for (int k = 0; k < count[j]; k++) {
        list[i] = j;
        i++;
      }
    }
    return list;
  }

  // review binary search tree
  public boolean searchTargetInBinarySearchTree(TreeNode root, int target) {
    if (root == null) {
      return false;
    }

    if (root.val < target) {
      return searchTargetInBinarySearchTree(root.right, target);
    } else if (root.val > target) {
      return searchTargetInBinarySearchTree(root.left, target);
    }
    return true;
  }

  // review insert and remove node in BST
  public TreeNode insertTreeNode(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    if (val < root.val) {
      root.left = insertTreeNode(root.left, val);
    } else if (val > root.val) {
      root.right = insertTreeNode(root.right, val);
    }
    return root;
  }

  public TreeNode removeTreeNode(TreeNode root, int val) {
    if (root == null) {
      return null;
    }

    if (val > root.val) {
      root.right = removeTreeNode(root.right, val);
    } else if (val < root.val) {
      root.left = removeTreeNode(root.left, val);
    } else {
      if (root.right == null) {
        return root.left;
      } else if (root.left == null) {
        return root.right;
      } else {
        TreeNode minTreeNode = minNode(root.right);
        root.val = minTreeNode.val;
        root.right = removeTreeNode(root.right, minTreeNode.val);
      }
    }

    return root;
  }

  public TreeNode minNode(TreeNode root) {
    TreeNode cur = root;
    while (cur != null && cur.left != null) {
      cur = cur.left;
    }
    return cur;
  }

  // review DFS
  // pre-order
  public void preOrderTraversal(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.println(root.val);
    preOrderTraversal(root.left);
    preOrderTraversal(root.right);
  }

  // review BFS
  // add root to queue
  // first loop checks if queue is not empty
  // second loop print out all values of nodes in the current values and add add
  // nodes in the next level to queue
  public void implementBFS(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();

    if (root != null) {
      queue.add(root);
    }
    while (!queue.isEmpty()) {
      int curLevelSize = queue.size();
      for (int i = 0; i < curLevelSize; i++) {
        TreeNode cur = queue.remove();
        System.out.println(cur.val);
        if (cur.right != null) {
          queue.add(cur.right);
        }
        if (cur.left != null) {
          queue.add(cur.left);
        }
      }
    }
  }

  // review treemaze
  public boolean isTherePath(TreeNode root) {
    if (root == null || root.val == 0) {
      return false;
    }
    if (root.left == null && root.right == null) {
      return true;
    }
    return isTherePath(root.left) || isTherePath(root.right);
  }

  // Matrix DFS
  // look unique paths of value 0 nodes
  public int matrixDFS(int[][] grid, int[][] visit, int r, int c) {
    int rows = grid.length;
    int cols = grid[0].length;
    // base cases
    if (
    // coordinate outbound of grid
    Math.min(r, c) < 0 || r == rows || c == cols ||
    // we reach the visited coordinate
        visit[r][c] == 1 ||
        // we reach the node with value 1
        grid[r][c] == 1) {
      return 0;
    }
    // if we reached the bottom right node, return 1 and backtrack to look for other
    // path
    if (r == rows - 1 && c == cols - 1) {
      return 1;
    }
    // if we does not reach the base case above, memmorize the visited coordinate
    visit[r][c] = 1;
    // traverse in 4 directions
    int count = 0;
    count += matrixDFS(grid, visit, r + 1, c);
    count += matrixDFS(grid, visit, r - 1, c);
    count += matrixDFS(grid, visit, r, c + 1);
    count += matrixDFS(grid, visit, r, c - 1);
    // delete visited coordinates when we backtrack since we want these coordinates
    // can be visited again in other directions
    visit[r][c] = 0;
    return count;
  }

  // Matrix BFS
  public int matrixBFS(int[][] grid) {
    // set up
    int rows = grid.length;
    int cols = grid[0].length;
    int[][] visit = new int[rows][cols];
    Queue<int[]> queue = new LinkedList<int[]>();
    visit[0][0] = 1;
    queue.add(new int[2]);
    // declare and initialize smallest steps to reach the bottom right vertex
    int steps = 0;
    // check base case where path is blocked at the top left and right bottom
    // vertices
    if (grid[0][0] == 1 && grid[rows - 1][cols - 1] == 1) {
      return -1;
    }
    // BFS
    while (!queue.isEmpty()) {
      //
      int queueSize = queue.size();
      // loop through all vertices in queue
      for (int i = 0; i < queueSize; i++) {
        int[] pair = queue.poll();
        int r = pair[0];
        int c = pair[1];
        // check if we reached the bottom right vertex
        if (r == rows - 1 && c == cols - 1) {
          return steps;
        }
        // check neighbors vertices
        int[][] neighbors = { { r, c + 1 }, { r, c - 1 }, { r + 1, c }, { r - 1, c } };
        for (int[] n : neighbors) {
          int newR = n[0];
          int newC = n[1];
          if (Math.min(newR, newC) < 0 || newR == rows || newC == cols || grid[newR][newC] == 1
              || visit[newR][newC] == 1) {
            continue;
          }
          // add neighbours to queue if they are not out bound, not blocked and not
          // visited
          // mark them as being visited
          queue.add(n);
          visit[newR][newC] = 1;
        }
      }
      steps++;
    }
    return -1;
  }

  // Adjacency list
  // Give a list of edges, build an adjacency list
  public Map<String, ArrayList<String>> buildAdjacencyList(String[][] edges) {
    Map<String, ArrayList<String>> adjList = new HashMap<String, ArrayList<String>>();

    for (String[] edge : edges) {
      String src = edge[0];
      String dst = edge[1];
      if (!adjList.containsKey(src)) {
        adjList.put(src, new ArrayList<String>());
      }
      if (!adjList.containsKey(dst)) {
        adjList.put(dst, new ArrayList<String>());
      }
      adjList.get(src).add(dst);
    }
    return adjList;
  }

  // DFS on adjacency list
  public int dfsAdjacencyList(Map<String, ArrayList<String>> adjList, HashSet<String> visit, String s, String e) {
    if (visit.contains(s)) {
      return 0;
    }
    if (e.equals(s)) {
      return 1;
    }
    int count = 0;
    visit.add(s);
    for (String neighbor : adjList.get(s)) {
      count += dfsAdjacencyList(adjList, visit, neighbor, e);
    }
    visit.remove(s);
    return count;
  }

  // BFS an adjacency list
  public int bfsAdjacencyList(Map<String, ArrayList<String>> adjList, String s, String e) {
    // base case
    if (s.equals(e)) {
      return 0;
    }
    if (!adjList.containsKey(s) || !adjList.containsKey(e)) {
      return -1;
    }
    // set up
    int steps = 0;
    HashSet<String> visit = new HashSet<String>();
    Queue<String> queue = new LinkedList<String>();
    visit.add(s);
    queue.add(s);

    while (!queue.isEmpty()) {
      int curSize = queue.size();
      for (int i = 0; i < curSize; i++) {
        String curNode = queue.poll();
        if (curNode.equals(e)) {
          return steps;
        }
        for (String neighbor : adjList.get(curNode)) {
          if (visit.contains(neighbor)) {
            continue;
          }
          queue.add(neighbor);
          visit.add(neighbor);
        }
      }
      steps++;
    }
    return -1;
  }

  // 2 Dimension DP
  // Optimize Matrix DFS (No specific exit coordinate required)
  // Recursion with no optimization - Memoization
  public int dfsMatrixNoMemoization(int r, int c, int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    if (r == rows && c == cols) {
      return 0;
    }
    if (r == rows - 1 && c == cols - 1) {
      return 1;
    }

    return dfsMatrixNoMemoization(r + 1, c, grid) + dfsMatrixNoMemoization(r, c + 1, grid);
  }

  // Recursion with memoization (Top-Down Approach)
  public int fibonacciWithCaching(int n, int[] cache) {
    if (n <= 1) {
      return n;
    }
    if (cache[n] != -1) {
      return cache[n];
    }

    cache[n] = fibonacciWithCaching(n - 1, cache) + fibonacciWithCaching(n - 2, cache);
    return cache[n];
  }

  public int topDownDfsMatrix(int r, int c, int[][] grid, int[][] cache) {
    int rows = grid.length;
    int cols = grid[0].length;

    if (r == rows && c == cols) {
      return 0;
    }

    if (cache[r][c] != -1) {
      return cache[r][c];
    }

    if (r == rows - 1 && c == cols - 1) {
      return 1;
    }

    cache[r][c] = topDownDfsMatrix(r + 1, c, grid, cache) + topDownDfsMatrix(r, c + 1, grid, cache);

    return cache[r][c];
  }

  // Bottom-up approach - Tabulation
  public int fibonacciTabulationSolution(int n) {
    if (n <= 1) {
      return n;
    }
    int[] fiboCal = { 0, 1 };

    for (int i = 2; i <= n; i++) {
      int tmp = fiboCal[1];
      fiboCal[1] = fiboCal[0] + fiboCal[1];
      fiboCal[0] = tmp;
    }

    return fiboCal[n];
  }

  public int bottomUpDfsMatrix(int[][] grid, int r, int c) {
    // idea is that the last column is filled with 1 (number of unique path reaching
    // bottom right corner), then we
    // calculate back from the base case
    int rows = grid.length;
    int cols = grid[0].length;

    int[] prevRow = new int[cols];

    for (int i = rows - 1; i >= 0; i--) {
      int[] curRow = new int[cols];
      curRow[cols - 1] = 1;
      for (int j = cols - 2; j >= 0; j--) {
        curRow[j] = curRow[j + 1] + prevRow[j];
      }
      prevRow = curRow;
    }
    return prevRow[0];
  }

  // find the largest sum of sublists in a list
  // Kadane algorithm
  public int findTheLargestSum(int[] inputVal) {
    int curSum = 0;
    int maxSum = inputVal[0];
    for (int i = 0; i < inputVal.length; i++) {
      curSum = Math.max(curSum, 0);
      curSum += inputVal[i];
      maxSum = Math.max(curSum, maxSum);
    }

    return maxSum;
  }

  // find the sublist in a list that has the largest sum
  // Sliding window
  public int[] findSublistThatHasTheLargestSum(int[] inputVal) {
    int L = 0;
    int maxL = 0;
    int maxR = 0;
    int cur = 0;
    int max = inputVal[0];
    for (int R = 0; R < inputVal.length; R++) {
      if (cur < 0) {
        cur = 0;
        L = R;
      }
      cur += inputVal[R];
      if (max < cur) {
        max = cur;
        maxL = L;
        maxR = R;
      }
    }
    int[] result = { maxL, maxR };
    return result;
  }

  // Sliding window with fixed size list
  // Return true if there are 2 duplicate elements in sub lists with size k
  // Brute force solution with two loops
  public boolean findTwoDuplicateValuesInFixedSizeSubListBruteForce(int[] inputList, int k) {
    for (int L = 0; L < inputList.length; L++) {
      for (int R = L + 1; R <= Math.min(inputList.length - 1, L + k - 1); R++) {
        if (inputList[R] == inputList[L]) {
          return true;
        }
      }
    }
    return false;
  }

  // Sliding fixed window solution
  // if we need to find more than two duplicate values, we can use hashset
  public boolean findTwoDuplicateSlidingFixedWindow(int[] inputList, int k) {
    Set<Integer> window = new HashSet<>();
    int L = 0;
    for (int R = 0; R < inputList.length; R++) {
      if (R - L + 1 > k) {
        window.remove(inputList[L]);
        L++;
      }
      if (window.contains(inputList[R])) {
        return true;
      }
      window.add(inputList[R]);
    }
    return false;
  }

  // Sliding window with variable size
  public int findTheLengthOfLongestArrayWithTheSameValueInEachPosition(int[] inputList) {
    int L = 0;
    int maxL = 0;
    for (int R = 0; R < inputList.length; R++) {
      if (inputList[L] != inputList[R]) {
        L = R;
      }
      maxL = Math.max(maxL, R - L + 1);

    }
    return maxL;
  }

  // Find the minimum length subarray, where the sum is greater than or equal to
  // the target. Assume all values are positive.
  public int findMinimumLength(int[] inputList, int target) {
    int L = 0;
    int curSum = 0;
    int minL = Integer.MAX_VALUE;
    for (int R = 0; R < inputList.length; R++) {
      curSum += inputList[R];
      while (curSum > target) {
        minL = Math.min(minL, R - L + 1);
        curSum -= inputList[L];
        L++;
      }
    }
    if (minL == Integer.MAX_VALUE) {
      return 0;
    }
    return minL;
  }

  // Two pointers
  // move two pointers to shrink the array from left and right
  // use length method to return the length of string
  // use charAt to get character from string using index
  public static boolean isPalindrome(String word) {
    int L = 0;
    int R = word.length() - 1;
    while (L < R) {
      if (word.charAt(L) != word.charAt(R)) {
        return false;
      }
      L++;
      R--;
    }
    return true;
  }

  // Target sum
  public static int[] targetSum(int[] nums, int target) {
    int L = 0;
    int R = nums.length - 1;
    while (L < R) {
      if (nums[L] + nums[R] < target) {
        L++;
      } else if (nums[L] + nums[R] > target) {
        R--;
      } else {
        int[] result = { L, R };
        return result;
      }
    }
    return null;
  }

  // Prefix sum
  // Use prefix sum to calculate sum of sublists
  public int[] buildPrefixSum(int[] inputList) {
    int[] prefixSum = new int[inputList.length];
    int sum = 0;
    for (int i = 0; i < inputList.length; i++) {
      sum += inputList[i];
      prefixSum[i] = sum;
    }
    return prefixSum;
  }

  // Given an array of integer values, calculate sum of subarray from l to r
  // indices
  public int sumRange(int[] inputList, int l, int r) {
    int[] prefixSum = buildPrefixSum(inputList);
    return prefixSum[r] - prefixSum[l > 0 ? l - 1 : 0];
  }

  // Trie
  class Trie {
    class TrieNode {
      boolean isWordEnd;
      Map<Character, TrieNode> edges = new HashMap<>();
    }

    private TrieNode root;

    public Trie() {
      root = new TrieNode();
    }

    private TrieNode findNode(String word) {
      TrieNode cur = root;
      for (char c : word.toCharArray()) {
        if (!cur.edges.containsKey(c)) {
          return null;
        }
        cur = cur.edges.get(c);
      }
      return cur;
    }

    public void insert(String word) {
      TrieNode cur = root;
      for (char c : word.toCharArray()) {
        if (!cur.edges.containsKey(c)) {
          cur.edges.put(c, new TrieNode());
        }
        cur = cur.edges.get(c);
      }
      cur.isWordEnd = true;
    }

    public boolean search(String word) {
      TrieNode ans = findNode(word);
      return ans == null ? false : ans.isWordEnd;
    }

    public boolean startsWith(String prefix) {
      TrieNode ans = findNode(prefix);
      return ans == null ? false : true;
    }
  }
}
