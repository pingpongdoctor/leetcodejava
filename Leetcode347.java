/**
0   1   2   3   4   5
1   1   1   2   2   3
                    i

key     value
1          3
2          2
3          1

k = 2

1,3   2,2   3,1
sort it in an descending order using the second element which is the frequency
1,3     2,2     3,1

Loop through the sorted array and add the first k elements to the result array

Time complexity: O(nlogn)
Space complexity: O(n)
*/

public class Leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

        int[][] arr = new int[map.size()][2];
        int i = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();

            arr[i][0] = key;
            arr[i][1] = val;
            i++; 
        }

        Arrays.sort(arr, (a,b) -> Integer.compare(b[1],a[1]));
        int[] result = new int[k];

        for (int j = 0; j < k; j++) {
            result[j] = arr[j][0];
        }

        return result;
    }
}