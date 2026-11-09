import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
Sort the array based on the first element in the ascending array
Use a list to add elements from original array gradually while merging the overlapping arrays

Time complexity: O(nlogn)
Space complexity: O(n)
*/

public class Leetcode56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++) {
            int[] cur = intervals[i];

            if(result.isEmpty()) {
                result.add(cur);
                continue;
            }

            int[] last = result.get(result.size() - 1);
            
            if(last[1] >= cur[0]) {
                last[1] = Math.max(last[1],cur[1]);
            } else {
                result.add(cur);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
}