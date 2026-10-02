/**
Track the product from right and from left. Doing this can help check the case where two negative numbers can form a larger number.
Calulate the products from both sides is calculating the prefix and suffix products of non-zero segments
0   1   2   3
2   3  - 2  4
    l               
         r

leftP = 6
rightP = -8
ans = 6

return 6

Time complexity: O(n)
Space complexity: O(1)
*/

public class Leetcode152 {
    public int maxProduct(int[] nums) {
        int leftP = 1;
        int rightP = 1;
        int ans = Integer.MIN_VALUE;

        int l = 0;
        int r = nums.length - 1;

        while(l < nums.length && r >= 0) {
            leftP *= nums[l];
            rightP *= nums[r];
            ans = Math.max(ans, Math.max(leftP, rightP));
            l++;
            r--;
            if(leftP == 0) {
                leftP = 1;
            }
            if(rightP == 0) {
                rightP = 1;
            }
        }

        return ans;
    }
}