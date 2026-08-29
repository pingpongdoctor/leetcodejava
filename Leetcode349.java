/**
intersection array is the array that includes elements included in two array

Solution 1: Add all elements of 1 array to 1 hashset. Then, loop through the second array and check if elements are included in set. If yes, add to the result set. Coppy all the elements in the result set to the result array.

nums1 = [4,5,9], nums2 = [9,4,9,8,4]
0   1   2   3   4   
9   4   9   8   4
i

first set
4   5   9

result set
9   4

Time complexity: O(m+n)
Space complexity: O(m+n)

Test:
nums1 = [4,9,5], nums2 = [9,4,9,8,4]
set1: 4 9  5

0   1   2   3   4
9   4   9   8   4
                i

result set: 9   4

result array 9  4

*/

public class Leetcode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        for (int val1 : nums1) {
            set.add(val1);
        }

        for (int val2 : nums2) {
            if(set.contains(val2)) {
                resultSet.add(val2);
            }
        }

        int[] resultArray = new int[resultSet.size()];
        int i = 0;
        for (int val : resultSet) {
            resultArray[i] = val;
            i++;
        }

        return resultArray;
    }
}

