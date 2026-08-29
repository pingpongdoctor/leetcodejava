/**
Solution 1
[1,0,1,0,1] goal = 2

prefixSum
[1,1,2,2,3]
         i

goal = curSum - prevSum
prevSum = curSum - goal

curSum =  3
prevSum =  3 - 2 = 1
count = 4

hashmap
key     value
 0        1
 1        2
 2        2

return count = 4

Time complexity: O(n)
Space complexity: O(n)

Solution: sliding window can be applied since there are only positive numbers
while j < length
if i < j and (cur > goal or there is 0) -> keep shriking and count prefix 0s
if the cur is not 0, set to 0, otherwise increment number of prefix 0s
after the inner loop, if cur == goal, add prefix 0s + 1 to the count
Keep the prefix 0 among iterations to keep tracking

Time complexity O(n)
Space complexity O(1)
*/
public class Leetcode930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int i = 0;
        int j = 0;
        int curSum = 0;
        int count = 0;
        int prefixZero = 0;

        while (j < nums.length) {
            curSum += nums[j];

            while(i < j && (curSum > goal || nums[i] == 0)) {
                if (nums[i] == 0) {
                    prefixZero++;
                } else {
                    prefixZero = 0;
                }

                curSum -= nums[i];
                i++;
            }

            if (curSum == goal) {
                count += prefixZero + 1;
            }

            j++;
        }

        return count;
    }
}