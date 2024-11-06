import java.util.Arrays;
import java.util.PriorityQueue;

//2542. Maximum Subsequence Score
//use 2d array to store pair of num1 and num2 by pairs
//Use minHeap to track the smallest value in window in nums1 to ensure the sum is largest
//Sort pairs using comparator num2 in decending order to ensure the current checking pair always has the lowest num2 value
//Do not need to check all cases if we using sorting and priority queue
public class MaximumSubsequenceScore {
  public long maxScore(int[] nums1, int[] nums2, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    long curSum = 0;
    long maxNum = 0;
    int n = nums1.length;
    int[][] pairs = new int[n][2];
    for (int i = 0; i < n; i++) {
      pairs[i][0] = nums1[i];
      pairs[i][1] = nums2[i];
    }
    Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
    for (int i = 0; i < n; i++) {
      int num1 = pairs[i][0];
      int num2 = pairs[i][1];
      curSum += num1;
      minHeap.offer(num1);
      if (minHeap.size() == k) {
        maxNum = Math.max(maxNum, curSum * num2);
        curSum -= minHeap.poll();
      }
    }
    return maxNum;
  }
}