/**
Solution 1: Use a HashMap to store the frequency of each element in nums1. Then I'll iterate through nums2. If the current element exists in the map and its frequency is greater than zero, I'll add it to the result and decrement its frequency. This ensures that an element can only appear in the result as many times as it appears in both arrays. Finally, I'll convert the ArrayList to an int array.

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]

    key     value
     4         1
     9         1
     5         1

     If element in the nums2 is included in the map and the frequency is > 0, decrement the frequency and add the val to the result array.
     If not, continue 

     ArrayList 4  9
    
    Time Complexity: O(m+n)
    Space complexity: O(m+min(m,n))
*/

public class Leetcode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();

        for (int val1 : nums1) {
            map.put(val1, map.getOrDefault(val1, 0) + 1);
        }

        for (int val2 : nums2) {
            if (map.containsKey(val2) && map.get(val2) > 0) {
                map.put(val2, map.get(val2) - 1);
                resultList.add(val2);
            }
        }

        int[] result = new int[resultList.size()];
        int i = 0;

        for (int num : resultList) {
            result[i] = num;
            i++;
        }

        return result;
    }
}