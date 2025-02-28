public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==1){
            if(nums[0]==target){
                return 0;
            }
            return target>nums[0] ? 1 : 0;
        }

        int L = 0;
        int R = nums.length-1;
        while(L<R){
            int mid = L + (R-L)/2;
            if(nums[mid]>target){
                R = mid - 1;
            } else if(nums[mid]<target){
                L = mid + 1;
            } else {
                return mid;
            }
        }
        return target>nums[L] ? L+1 : L;
    }
}
