/**
10  5   2   6
                r
    l

at the start of an iteration, update the curProduct
outter loop interate through each element with r control variable
    if the product is less than k, increment count, expand it by moving to the next iteration
    if the product is greater than or equal to the k, use an inner loop to shrink it, before move the l, we need to divide the product by the element at i. After shrinking, we check if it is less than k to increment

count = 4
curProduct = 60
while (l < length) {
curProduct /= element at l
if curProduct < k, count ++
l++
}

Time complexity: O(n)
Space complexity: O(1)

10  5   2   6   
                r
            l
cur = 6
count = 6
*/

public class Leetcode713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2) {
            return 0;
        }

        int i = 0;
        int j = 0;
        int count = 0;
        int product = 1;

        while (j < nums.length) {
            product *= nums[j];
            
            while (product >= k) {
                product /= nums[i];
                i++;
            }

            count += j - i + 1;
            j++;
        }

        return count;
    }
}