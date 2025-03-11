import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 373. Find K Pairs with Smallest Sums
// use min heap to store pairs starting from index 0 of the nums2
// everytime we poll a pair from heap, we add a new pair by checking the next index in the nums2
public class FindKPairsSmallestSums {
     public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums1.length==1 && nums2.length==1 && k==1){
            List<Integer> rs = new ArrayList<>();
            rs.add(nums1[0]);
            rs.add(nums2[0]);
            ans.add(rs);
            return ans;
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int n : nums1){
            minHeap.add(new int[] {n + nums2[0], 0});
        }
        while(k>0 && !minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            int sum = cur[0];
            int pos = cur[1];
            List<Integer> rs = new ArrayList<>();
            rs.add(sum - nums2[pos]);
            rs.add(nums2[pos]);
            ans.add(rs);
            if(pos+1<nums2.length){
                minHeap.add(new int[] {sum - nums2[pos] + nums2[pos+1], pos+1});
            }
            k--;
        }
        return ans;
    }
}
