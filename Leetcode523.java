/**
0   1   2   3   4
23  2    4  6    7

0   1   2   3    4
23  25  29  35   42
        i   i+1    j

curSum - prevSum = result%k
curSum%k = r1
prevSum%k = r2
r1 == r2

cur = 25
remainder = 29%6 = 5

if the remainder is not in the map, add key = remainder and value = index of the curSum
if the remainder is included
    if i - (the index of the prevSum - 1) + 1 >= 2 -> there are at least 2 element in the subarray from prevSum index to the i index. Let's say the curSum idx is i and the prevSum idx is j, the difference of the them is the sum of the array ranging from j - 1 to i. The length of array is i - (j-1) + 1, that should be >=2

hashmap
5   0
1   1

Time complexity: O(n)
Space complexity: O(min(n,k)) since num%k has k distince possible values

Test
[23,2,4,6,6]
0   1   2   3   4
23  25  29  35  41
            i

key     value
2       0
4       1
1       2

*/

public class Leetcode523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length <2) {
            return false;
        }

        if (k==1) {
            return true;
        }

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int j = 0; j < nums.length; j++) {
            int cur = nums[j];
            int remainder = cur%k;

            if(remainder == 0 && j + 1 >=2) {
                return true;
            }

            if(!map.containsKey(remainder)) {
                map.put(remainder, j);
            } else {
                if (j - map.get(remainder) >= 2) {
                    return true;
                }
            }
        }

        return false;
    }
}