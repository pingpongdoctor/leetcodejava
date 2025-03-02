// 34. Find First and Last Position of Element in Sorted Array
// Use binary search to search leftmost and rightmost target
public class FindFirstLastPositionElementSortedArray {
    private int findPos(int[] nums, int target, boolean findLeft) {
        int L = 0;
        int R = nums.length-1;
        int pos = -1;

        while(L<=R){
            int midIdx = L + (R-L)/2;
            int mid = nums[midIdx];

            if(target<mid){
                R = midIdx-1;
            } else if(target>mid){
                L = midIdx+1;
            } else {
                pos = midIdx;
                if(findLeft){
                    R = midIdx-1;
                } else {
                    L = midIdx+1;
                }
            }
        }

        return pos;
    }

    public int[] searchRange(int[] nums, int target) {
        int left = findPos(nums,target,true);
        int right = findPos(nums,target,false);
        int[] ans = {left,right};
        return ans;
    }
}
