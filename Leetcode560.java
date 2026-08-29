/**
Question I am gonna ask assuming we have no constraints provided in an interview:
1. Can the element value be negative?
2. Is it sorted in an ascending or descending order?
3. Can the subarrays overlap?
4. What is the maximum and minimum length of the array?
5. Are we looking for contiguous subarrays?

Solution 1: Prefix sums allow us to calculate the sum of any subarray using the difference between two prefix sums. The hashmap allows us to keep track the previous prefix sum that has occurred.
If we see any prefix sum k - curSum before, it represents one valid sub array

We can't use the standard two-pointer approach because the array can contain negative numbers. Adding or removing an element doesn't guarantee that the sum will increase or decrease in a predictable way

            0   1   2   3   4   5   6       
nums        5   1   2   3   2   -1  1       
                                    i
            0   1   2   3   4   5   6
prefixSum   5   6   8   11  13  12  13
                                    i
hashmap
    key         value (frequency)
     0            1
     5            1
     6            1
     8            1
     11            1
     13             2
     12             1

currentPrefix - previousPrefix = k
k = curPrefix - prevPrefix
prevPrefix = curPrefix - k  = 13 - 5 = 8

curSum = 11
output = 5
result = 4 (increment by the frequency of the leftPrefix in the map)

Time complexity: O(n)
Space complecity: O(n)

Test:
k = 5
            0   1   2   3   4   5   6       
nums        5   1   2   3   2   -1  1       
                                        i

            0   1   2   3   4   5   6
prefixsum   5   6   8   11  13  12  13
                                        j
result = 4
curPrefix = 13
prevPrefix = cur - k = 13 - 5 = 8

hashmap
    key         value
    0              1
    5               1
    6               1
    8               1
    11              1
    13              2
    12              1
*/

public class Leetcode560 {
    private int[] helper(int[] nums) {
        int[] result = new int[nums.length];
        int curSum = 0;

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            result[i] = curSum;
        }

        return result;
    }

    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = helper(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int result = 0;

        for (int i = 0; i < prefixSum.length; i++) {
            int curPrefix = prefixSum[i];
            int leftPrefix = curPrefix - k;

            if (map.containsKey(leftPrefix)) {
                result += map.get(leftPrefix);
            }

            map.put(curPrefix, map.getOrDefault(curPrefix, 0) + 1);
        }

        return result;
    }
}