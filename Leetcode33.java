/**
Solution: Use binary search to search for the target. Identify if target is greater than middle value or less than it.

If the middle value is greater than or equal to the l value and smaller than or equal to the r value
    if looking for the greater value, search on the right
    else search on the left

If the middle value belongs to the left sorted array.
    if looking for greater value, search on the right
    if looking for the smaller value
        if target >= l value, search on the left
        else search on the right
If the middle value belongs to the right sorted array
    if looking for smaller value, search on the left
    if looking for greater value
        if target <= r value, search on the right
        else search on the left

Time complexity: O(logn);
Space complexity: O(1);
*/

public class Leetcode33 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l)/2;

            if(nums[m] == target) {
                return m;
            }

            if(nums[m] >= nums[l] && nums[m] <= nums[r]) {
                if(nums[m] < target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
                continue;
            }

            if (nums[m] >= nums[l]) {
                if(nums[m] < target) {
                    l = m + 1;
                } else {
                    if(target >= nums[l]) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
            } else {
                if(nums[m] > target) {
                    r = m - 1;
                } else {
                    if (target <= nums[r]) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
            }
        }

        return -1;
    }
}
